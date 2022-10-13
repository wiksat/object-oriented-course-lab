package agh.ics.oop;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
//        Direction[] direction= assign(args);
//        run(direction);
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));

//        System.out.println(MapDirection.NORTH.toUnitVector());
//        System.out.println(MapDirection.SOUTH.toUnitVector());
//        System.out.println(MapDirection.EAST.toUnitVector());
//        System.out.println(MapDirection.WEST.toUnitVector());



        System.out.println("system zakończył działanie");
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
