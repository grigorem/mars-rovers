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
}