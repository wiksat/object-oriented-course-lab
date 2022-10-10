package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        Direction[] direction=new Direction[args.length];
        int counter=0;
        for(String argument : args) {
            Direction kierunek = switch (argument) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "r" -> Direction.RIGHT;
                case "l" -> Direction.LEFT;
                default -> Direction.DEFAULT;
            };
            direction[counter]=kierunek;
            counter ++;
        }
        run(direction);
        System.out.println("system zakończył działanie");
    }

    public static void run(Direction[] args) {
//        System.out.println("zwierzak idzie do przodu");
//        int licznik=0;
        for(Direction argument : args){
//            if (licznik==0){
//                System.out.print(argument);
//            }else{
//                System.out.print(","+argument);
//            }
//            licznik=licznik+1;
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
                case DEFAULT -> "";
            };
            System.out.println(message);
        }
    }
}
