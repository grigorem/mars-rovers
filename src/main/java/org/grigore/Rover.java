package org.grigore;

public class Rover {
    int x;
    int y;
    Direction direction;

    /* constructors */
    public Rover(int x, int y, char direction) {
        setX(x);
        setY(y);
        setDirection(Direction.getFromChar(direction));
    }

    /* public methods */
    public void move() {
        MovementController.move(this);
    }

    public void turnLeft() {
        MovementController.turnLeft(this);
    }

    public void turnRight() {
        MovementController.turnRight(this);
    }

    /* default getters and setters */
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
