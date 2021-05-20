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
        roverX = limitValue(roverX, 0, plateau.getxLimit());
        roverY = limitValue(roverY, 0, plateau.getyLimit());

        if (positionIsEmpty(plateau, roverX, roverY)) {
            rover.setX(roverX);
            rover.setY(roverY);
        }
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

    private static boolean positionIsEmpty(Plateau plateau, int x, int y) {
        for (Rover rover: plateau.getRovers()) {
            if (rover.getX() == x && rover.getY() == y) {
                return false;
            }
        }
        return true;
    }
}
