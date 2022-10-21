package agh.ics.oop;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        Animal animal=new Animal();
        OptionParser optionParser=new OptionParser();
//        System.out.println(animal.toString());
//        animal.move(MoveDirection.RIGHT);
//        System.out.println(animal.toString());
//        animal.move(MoveDirection.FORWARD);
//        System.out.println(animal.toString());
//        animal.move(MoveDirection.FORWARD);
//        System.out.println(animal.toString());
//        animal.move(MoveDirection.FORWARD);
//        System.out.println(animal.toString());
        MoveDirection[] moveDirections=optionParser.parse(args);
        doIt(moveDirections,animal);



        System.out.println("system zakończył działanie");
    }
    public static void doIt(MoveDirection[] moveDirections, Animal animal){
        for (MoveDirection moveDirection : moveDirections) {
            animal.move(moveDirection);
        }
    }
    public static Direction[] assign(String[] args) {
        int counter=0;
        Direction[] direction=new Direction[args.length];

        for(String argument : args) {
            switch (argument) {
                case "f" -> {
                    direction[counter] = Direction.FORWARD;
                    counter++;
                }
                case "b" -> {
                    direction[counter] = Direction.BACKWARD;
                    counter++;
                }
                case "r" -> {
                    direction[counter] = Direction.RIGHT;
                    counter++;
                }
                case "l" -> {
                    direction[counter] = Direction.LEFT;
                    counter++;
                }
            }
        }
        return Arrays.copyOfRange(direction,0,counter);
    }
    public static void run(Direction[] args) {
        for(Direction argument : args){
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };
            System.out.println(message);
        }
    }
}
