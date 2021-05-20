package org.grigore;

public class MovementController {

    /* public methods */
    public static void move(Rover rover) {
        int roverX = rover.getX();
        int roverY = rover.getY();
        switch (rover.getDirection()) {
            case NORTH:
                roverY++;
                break;
            case EAST:
                roverX++;
                break;
            case SOUTH:
                roverY--;
                break;
            case WEST:
                roverX--;
                break;
        }
        Plateau plateau = Plateau.getInstance();
        rover.setX(limitValue(roverX, 0, plateau.getxLimit()));
        rover.setY(limitValue(roverY, 0, plateau.getyLimit()));
    }

    public static void turnLeft(Rover rover) {
        rover.setDirection(rover.getDirection().previous());
    }

    public static void turnRight(Rover rover) {
        rover.setDirection(rover.getDirection().next());
    }

    /* private methods */
    private static int limitValue(int value, int min, int max) {
        if (value < min) {
            return min;
        }
        return Math.min(value, max);
    }
}
