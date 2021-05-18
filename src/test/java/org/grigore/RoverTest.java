package org.grigore;

import junit.framework.TestCase;

public class RoverTest extends TestCase {

    public void testMove() {
        Rover rover = new Rover(1, 1, 'N');
        assertTrue(rover.move());
    }

    public void testTurnLeft() {
        Rover rover = new Rover(1, 1, 'N');
        assertTrue(rover.turnLeft());
    }

    public void testTurnRight() {
        Rover rover = new Rover(1, 1, 'N');
        assertTrue(rover.turnRight());
    }

    public void testGetX() {
        Rover rover = new Rover(1, 1, 'N');
        assertEquals(rover.getX(), 1);
    }

    public void testGetY() {
        Rover rover = new Rover(1, 1, 'N');
        assertEquals(rover.getY(), 1);
    }

    public void testGetOrientation() {
        Rover rover = new Rover(1, 1, 'N');
        assertEquals(rover.getDirection(), Direction.NORTH);
    }
}