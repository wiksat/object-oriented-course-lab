package agh.ics.oop;


public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        Animal animal=new Animal();
        OptionParser optionParser=new OptionParser();
//        animal.move(MoveDirection.RIGHT);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.FORWARD);
//        System.out.println(animal.toString());
        MoveDirection[] moveDirections=optionParser.parse(args);
        run(moveDirections,animal);
        System.out.println("system zakończył działanie");
//        Zadanie 10:
//        Aby zapobiec pojawieniu się dwóch zwierząt na tym samym miejscu można stworzyć w klasie Animals metody zwracające pozycję zwierzęcia (jako x i y, bo teraz mamy tylko stringa),
//        obliczenie na które polu powinno pojawić się zwierze, a następnie wywołanie metody "isAt" dla drugiego zwierzęcia od obliczonej pozycji.
//        Wtedy dowiemy się czy miejsce jest puste, a jeśli tak, to ruszamy się zwierzakiem
    }
    public static void run(MoveDirection[] args, Animal animal){
        for(MoveDirection argument : args){
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };
            animal.move(argument);
            System.out.println(message);
            System.out.println(animal);
        }
    }
}
