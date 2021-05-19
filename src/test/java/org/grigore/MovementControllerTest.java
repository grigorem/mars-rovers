package org.grigore;

import junit.framework.TestCase;

public class MovementControllerTest extends TestCase {

    public void testMove() {
        Plateau plateau = Plateau.getInstance(10, 10);
        Rover rover = new Rover(4, 4, 'S');
        MovementController.move(rover);
        assertEquals(rover.getY(), 3);
    }

    public void testTurnLeft() {
        Plateau plateau = Plateau.getInstance(10, 10);
        Rover rover = new Rover(4, 4, 'W');
        MovementController.turnLeft(rover);
        assertEquals(rover.getDirection(), Direction.SOUTH);
    }

    public void testTurnRight() {
        Plateau plateau = Plateau.getInstance(10, 10);
        Rover rover = new Rover(4, 4, 'S');
        MovementController.turnRight(rover);
        assertEquals(rover.getDirection(), Direction.WEST);
    }

    public void testComplexMovement1() {
        Plateau plateau = Plateau.getInstance(5, 5);
        Rover rover = new Rover(3, 3, 'E');

        MovementController.move(rover);
        MovementController.move(rover);
        MovementController.turnRight(rover);
        MovementController.move(rover);
        MovementController.move(rover);
        MovementController.turnRight(rover);
        MovementController.move(rover);
        MovementController.turnRight(rover);
        MovementController.turnRight(rover);
        MovementController.move(rover);

        assertTrue(
                rover.getX() == 5 &&
                rover.getY() == 1 &&
                rover.getDirection() == Direction.EAST);
    }

    public void testComplexMovement2() {
        Plateau plateau = Plateau.getInstance(5, 5);
        Rover rover = new Rover(1, 2, 'N');

        MovementController.turnLeft(rover);
        MovementController.move(rover);
        MovementController.turnLeft(rover);
        MovementController.move(rover);
        MovementController.turnLeft(rover);
        MovementController.move(rover);
        MovementController.turnLeft(rover);
        MovementController.move(rover);
        MovementController.move(rover);

        assertTrue(
                rover.getX() == 1 &&
                rover.getY() == 3 &&
                rover.getDirection() == Direction.NORTH);
    }

    public void testTwoRovers() {
        Plateau plateau = Plateau.getInstance(5, 5);
        Rover rover1 = new Rover(1, 2, 'N');
        Rover rover2 = new Rover(3, 3, 'E');

        // rover 1 movement
        MovementController.turnLeft(rover1);
        MovementController.move(rover1);
        MovementController.turnLeft(rover1);
        MovementController.move(rover1);
        MovementController.turnLeft(rover1);
        MovementController.move(rover1);
        MovementController.turnLeft(rover1);
        MovementController.move(rover1);
        MovementController.move(rover1);

        // rover 2 movement
        MovementController.move(rover2);
        MovementController.move(rover2);
        MovementController.turnRight(rover2);
        MovementController.move(rover2);
        MovementController.move(rover2);
        MovementController.turnRight(rover2);
        MovementController.move(rover2);
        MovementController.turnRight(rover2);
        MovementController.turnRight(rover2);
        MovementController.move(rover2);

        assertTrue(
                rover1.getX() == 1 &&
                rover1.getY() == 3 &&
                rover1.getDirection() == Direction.NORTH &&
                rover2.getX() == 5 &&
                rover2.getY() == 1 &&
                rover2.getDirection() == Direction.EAST);
    }
}