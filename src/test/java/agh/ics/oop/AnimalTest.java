package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    public OptionParser optionParser=new OptionParser();
    @Test
    void correctOrientation(){
        Animal animal1=new Animal();
        String[] strAr1=new String[] {"r", "r", "l","l","r"};
        MoveDirection[] moveDirections1=optionParser.parse(strAr1);
        for (MoveDirection moveDirection : moveDirections1) {
            animal1.move(moveDirection);
        }
        Assertions.assertEquals("(2,2) Wschód",animal1.toString());

        Animal animal2=new Animal();
        String[] strAr2=new String[] {"r", "r", "l","l","l"};
        MoveDirection[] moveDirections2=optionParser.parse(strAr2);
        for (MoveDirection moveDirection : moveDirections2) {
            animal2.move(moveDirection);
        }
        Assertions.assertEquals("(2,2) Zachód",animal2.toString());
        }
    @Test
    void correctPositions(){
        Animal animal1=new Animal();
        String[] strAr1=new String[] {"r", "f", "f","f"};
        MoveDirection[] moveDirections1=optionParser.parse(strAr1);
        for (MoveDirection moveDirection : moveDirections1) {
            animal1.move(moveDirection);
        }
        Assertions.assertEquals("(4,2) Wschód",animal1.toString());

        Animal animal2=new Animal();
        String[] strAr2=new String[] {"f", "f", "r","f","r","f","l","b","f","f","r"};
        MoveDirection[] moveDirections2=optionParser.parse(strAr2);
        for (MoveDirection moveDirection : moveDirections2) {
            animal2.move(moveDirection);
        }

        Assertions.assertEquals("(4,3) Południe",animal2.toString());
    }
    @Test
    void notOutOfMap(){
        Animal animal1=new Animal();
        String[] strAr1=new String[] {"f", "f", "f","f"};
        MoveDirection[] moveDirections1=optionParser.parse(strAr1);
        for (MoveDirection moveDirection : moveDirections1) {
            animal1.move(moveDirection);
        }
        Assertions.assertEquals("(2,4) Północ",animal1.toString());

        Animal animal2=new Animal();
        String[] strAr2=new String[] {"b","b","b","b"};
        MoveDirection[] moveDirections2=optionParser.parse(strAr2);
        for (MoveDirection moveDirection : moveDirections2) {
            animal2.move(moveDirection);
        }
        Assertions.assertEquals("(2,0) Północ",animal2.toString());

        Animal animal3=new Animal();
        String[] strAr3=new String[] {"r","b","b","b","b"};
        MoveDirection[] moveDirections3=optionParser.parse(strAr3);
        for (MoveDirection moveDirection : moveDirections3) {
            animal3.move(moveDirection);
        }
        Assertions.assertEquals("(0,2) Wschód",animal3.toString());

        Animal animal4=new Animal();
        String[] strAr4=new String[] {"r","f","f","f","f"};
        MoveDirection[] moveDirections4=optionParser.parse(strAr4);
        for (MoveDirection moveDirection : moveDirections4) {
            animal4.move(moveDirection);
        }
        Assertions.assertEquals("(4,2) Wschód",animal4.toString());
    }
}
