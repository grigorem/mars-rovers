package org.grigore;

public class Rover {
    int x;
    int y;
    char orientation;

    /* constructors */
    public Rover(int x, int y, char orientation) {
        setX(x);
        setY(y);
        setOrientation(orientation);
    }

    /* public methods */
    public boolean move() {
        return true;
    }

    public boolean turnLeft() {
        return true;
    }

    public boolean turnRight() {
        return true;
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

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }
}
