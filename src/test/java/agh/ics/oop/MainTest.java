package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    public OptionParser optionParser=new OptionParser();
    @Test
    void mainTest(){
        Animal animal1=new Animal();
        String[] strAr1=new String[] {"r", "f", "f","f"};
        MoveDirection[] moveDirections1=optionParser.parse(strAr1);
        World.doIt(moveDirections1,animal1);
        Assertions.assertEquals("(4,2) Wschód",animal1.toString());
    }
}
