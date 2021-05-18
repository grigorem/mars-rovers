package org.grigore;

import junit.framework.TestCase;

public class DirectionTest extends TestCase {

    public void testNorth() {
        assertEquals(Direction.NORTH.name(), "NORTH");
    }

    public void testEast() {
        assertEquals(Direction.EAST.name(), "EAST");
    }

    public void testSouth() {
        assertEquals(Direction.SOUTH.name(), "SOUTH");
    }

    public void testWest() {
        assertEquals(Direction.WEST.name(), "WEST");
    }

    public void testNext() {
        assertEquals(Direction.WEST.next(), Direction.NORTH);
    }
    public void testPrevious() {
        assertEquals(Direction.NORTH.previous(), Direction.WEST);
    }
}