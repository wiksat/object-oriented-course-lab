package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    void all(){
//        int x1=1;
//        int y1=2;
//        int x2=-2;
//        int y2=1;
//        Vector2d position1 = new Vector2d(x1,y1);
//        Vector2d position2 = new Vector2d(x2,y2);
////        ADD
//        Assertions.assertEquals(new Vector2d(x1+x2,y1+y2),position1.add(position2));
////        SUBSTRACT
//        Assertions.assertEquals(new Vector2d(x1-x2,y1-y2),position1.subtract(position2));
////        PRECEDENS
//        if (x1 <= x2 && y1 <= y2){
//            Assertions.assertTrue(position1.precedes(position2));
//        }else{
//            Assertions.assertFalse(position1.precedes(position2));
//        }
////        FOLLOWS
//        if (x1 >= x2 && y1 >= y2){
//            Assertions.assertTrue(position1.follows(position2));
//        }else{
//            Assertions.assertFalse(position1.follows(position2));
//        }
////        OPPOSITE
//        Assertions.assertEquals(new Vector2d(-x1,-y1),position1.opposite());
//
////        Assertions.assertEquals(new Vector2d(-x2,-y2),position2.opposite());
//
////        UPPER_RIGHT
//        Assertions.assertEquals(new Vector2d(Math.max(x1,x2), Math.max(y1, y2)),position1.upperRight(position2));
////        LOWER_LEFT
//        Assertions.assertEquals(new Vector2d(Math.min(x1,x2), Math.min(y1, y2)),position1.lowerLeft(position2));
////        TO_STRING
//        Assertions.assertEquals("("+Integer.toString(x1)+","+Integer.toString(y1)+")",position1.toString());
//
////        Assertions.assertEquals("("+Integer.toString(x2)+","+Integer.toString(y2)+")",position2.toString());
//
////        EQUALS
//        Assertions.assertTrue(position1.equals(position1));
//        Assertions.assertFalse(position1.equals(position2));
///////////////////////////////////

        int[] Xes = {1, -2,4};
        int[] Yes = {2, 1,4};
        Vector2d[] tab=new Vector2d[Xes.length];

        for (int i = 0; i < Xes.length; i++) {
            tab[i]=new Vector2d(Xes[i],Yes[i]);
        }

        for (int i = 0; i < tab.length-1; i++) {
            //        ADD
            Assertions.assertEquals(new Vector2d(Xes[i]+Xes[i+1],Yes[i]+Yes[i+1]),tab[i].add(tab[i+1]));
            //        SUBSTRACT
            Assertions.assertEquals(new Vector2d(Xes[i]-Xes[i+1],Yes[i]-Yes[i+1]),tab[i].subtract(tab[i+1]));
            //        PRECEDENS
            if (Xes[i] <= Xes[i+1] && Yes[i] <= Yes[i+1]){
                Assertions.assertTrue(tab[i].precedes(tab[i+1]));
            }else{
                Assertions.assertFalse(tab[i].precedes(tab[i+1]));
            }
            //        FOLLOWS
            if (Xes[i] >= Xes[i+1] && Yes[i] >= Yes[i+1]){
                Assertions.assertTrue(tab[i].follows(tab[i+1]));
            }else{
                Assertions.assertFalse(tab[i].follows(tab[i+1]));
            }
            //        OPPOSITE
            Assertions.assertEquals(new Vector2d(-Xes[i],-Yes[i]),tab[i].opposite());
            //        UPPER_RIGHT
            Assertions.assertEquals(new Vector2d(Math.max(Xes[i],Xes[i+1]), Math.max(Yes[i], Yes[i+1])),tab[i].upperRight(tab[i+1]));
            //        LOWER_LEFT
            Assertions.assertEquals(new Vector2d(Math.min(Xes[i],Xes[i+1]), Math.min(Yes[i], Yes[i+1])),tab[i].lowerLeft(tab[i+1]));
            //        TO_STRING
            Assertions.assertEquals("("+Integer.toString(Xes[i])+","+Integer.toString(Yes[i])+")",tab[i].toString());
            //        EQUALS
            Assertions.assertTrue(tab[i].equals(tab[i]));
            Assertions.assertFalse(tab[i].equals(tab[i+1]));
        }


    }
}
