package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    public int x1=1;
    public int y1=2;
    public int x2=-2;
    public int y2=1;
    public Vector2d position1 = new Vector2d(x1,y1);
    public Vector2d position2 = new Vector2d(x2,y2);
    @Test
    void testAdd(){
        Assertions.assertEquals(new Vector2d(x1+x2,y1+y2),position1.add(position2));
    }
    @Test
    void testSub(){
        Assertions.assertEquals(new Vector2d(x1-x2,y1-y2),position1.subtract(position2));
    }
    @Test
    void testPrecedens(){
        if (x1 <= x2 && y1 <= y2){
            Assertions.assertTrue(position1.precedes(position2));
        }else{
            Assertions.assertFalse(position1.precedes(position2));
        }
    }
    @Test
    void testFollows(){
        if (x1 >= x2 && y1 >= y2){
            Assertions.assertTrue(position1.follows(position2));
        }else{
            Assertions.assertFalse(position1.follows(position2));
        }
    }
    @Test
    void testOpposite(){
        Assertions.assertEquals(new Vector2d(-x1,-y1),position1.opposite());
    }
    @Test
    void testUPPER_RIGHT(){
        Assertions.assertEquals(new Vector2d(Math.max(x1,x2), Math.max(y1, y2)),position1.upperRight(position2));
    }
    @Test
    void testLOWER_LEFT(){
        Assertions.assertEquals(new Vector2d(Math.min(x1,x2), Math.min(y1, y2)),position1.lowerLeft(position2));
    }
    @Test
    void testTO_STRING(){
        Assertions.assertEquals("("+Integer.toString(x1)+","+Integer.toString(y1)+")",position1.toString());
    }
    @Test
    void testEQUALS(){
        Assertions.assertTrue(position1.equals(position1));
    }

}
