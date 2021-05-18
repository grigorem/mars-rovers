package org.grigore;

public class MovementController {

    public static void move(Rover rover) {
        switch (rover.getDirection()) {
            case NORTH:
                rover.setY(rover.getY() + 1);
                break;
            case EAST:
                rover.setX(rover.getX() + 1);
                break;
            case SOUTH:
                rover.setY(rover.getY() - 1);
                break;
            case WEST:
                rover.setX(rover.getX() - 1);
                break;
        }
        Plateau plateau = Plateau.getInstance();
        rover.setX(rover.getX() % plateau.getxLimit());
        rover.setY(rover.getY() % plateau.getyLimit());
    }

    public static void turnLeft(Rover rover) {
        rover.setDirection(rover.getDirection().previous());
    }

    public static void turnRight(Rover rover) {
        rover.setDirection(rover.getDirection().next());
    }
}
