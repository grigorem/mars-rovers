package org.grigore;

import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

    @Test
    public void testMoveUp() {
        Plateau.deleteInstance();
        Plateau plateau = Plateau.getInstance(100, 100);
        Rover rover = new Rover(1, 2, 'N');
        rover.move();
        Assert.assertEquals(rover.getY(), 3);
    }

    @Test
    public void testTurnLeft() {
        Plateau.deleteInstance();
        Plateau plateau = Plateau.getInstance(100, 100);
        Rover rover = new Rover(3, 4, 'N');
        rover.turnLeft();
        Assert.assertEquals(rover.getDirection(), Direction.WEST);
    }

    @Test
    public void testTurnRight() {
        Plateau.deleteInstance();
        Plateau plateau = Plateau.getInstance(100, 100);
        Rover rover = new Rover(1, 1, 'S');
        rover.turnRight();
        Assert.assertEquals(rover.getDirection(), Direction.WEST);
    }

    @Test
    public void testGetX() {
        Plateau.deleteInstance();
        Plateau plateau = Plateau.getInstance(100, 100);
        Rover rover = new Rover(1, 1, 'N');
        Assert.assertEquals(rover.getX(), 1);
    }

    @Test
    public void testGetY() {
        Plateau.deleteInstance();
        Plateau plateau = Plateau.getInstance(100, 100);
        Rover rover = new Rover(1, 1, 'N');
        Assert.assertEquals(rover.getY(), 1);
    }

    @Test
    public void testGetOrientation() {
        Plateau.deleteInstance();
        Plateau plateau = Plateau.getInstance(100, 100);
        Rover rover = new Rover(1, 1, 'N');
        Assert.assertEquals(rover.getDirection(), Direction.NORTH);
    }
}