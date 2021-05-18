package org.grigore;

import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

    @Test
    public void testMoveUp() {
        Plateau plateau = Plateau.getInstance(100, 100);
        Rover rover = new Rover(1, 2, 'N');
        rover.move();
        Assert.assertEquals(rover.getY(), 3);
    }

    @Test
    public void testTurnLeft() {
        Rover rover = new Rover(3, 4, 'N');
        rover.turnLeft();
        Assert.assertEquals(rover.getDirection(), Direction.WEST);
    }

    @Test
    public void testTurnRight() {
        Rover rover = new Rover(1, 1, 'S');
        rover.turnRight();
        Assert.assertEquals(rover.getDirection(), Direction.WEST);
    }

    @Test
    public void testGetX() {
        Rover rover = new Rover(1, 1, 'N');
        Assert.assertEquals(rover.getX(), 1);
    }

    @Test
    public void testGetY() {
        Rover rover = new Rover(1, 1, 'N');
        Assert.assertEquals(rover.getY(), 1);
    }

    @Test
    public void testGetOrientation() {
        Rover rover = new Rover(1, 1, 'N');
        Assert.assertEquals(rover.getDirection(), Direction.NORTH);
    }
}