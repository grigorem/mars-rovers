package org.grigore;

import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void testNorth() {
        Assert.assertEquals(Direction.NORTH.name(), "NORTH");
    }

    @Test
    public void testEast() {
        Assert.assertEquals(Direction.EAST.name(), "EAST");
    }

    @Test
    public void testSouth() {
        Assert.assertEquals(Direction.SOUTH.name(), "SOUTH");
    }

    @Test
    public void testWest() {
        Assert.assertEquals(Direction.WEST.name(), "WEST");
    }

    @Test
    public void testNext() {
        Assert.assertEquals(Direction.WEST.next(), Direction.NORTH);
    }

    @Test
    public void testPrevious() {
        Assert.assertEquals(Direction.NORTH.previous(), Direction.WEST);
    }
}