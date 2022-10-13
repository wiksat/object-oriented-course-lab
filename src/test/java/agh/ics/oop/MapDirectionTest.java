package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class MapDirectionTest {


    @Test
    void next() {
        Assertions.assertEquals(MapDirection.EAST,MapDirection.NORTH.next());
        Assertions.assertEquals(MapDirection.SOUTH,MapDirection.EAST.next());
        Assertions.assertEquals(MapDirection.WEST,MapDirection.SOUTH.next());
        Assertions.assertEquals(MapDirection.NORTH,MapDirection.WEST.next());
    }
}
