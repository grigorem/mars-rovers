package org.grigore;

public class Plateau {
    int xLimit;
    int yLimit;
    static Plateau plateau = null;

    /* constructors */
    private Plateau(int x, int y) {
        setxLimit(x);
        setyLimit(y);
    }

    /* public methods */
    public static Plateau getInstance(int x, int y) {
        if (plateau == null) {
            plateau = new Plateau(x, y);
        } else {
            plateau.setxLimit(x);
            plateau.setyLimit(y);
        }
        return plateau;
    }

    public static Plateau getInstance() {
        if (plateau == null) {
            plateau = new Plateau(0, 0); // create an empty plateau
        }
        return plateau;
    }

    /* default getters and setters */
    public int getxLimit() {
        return xLimit;
    }

    private void setxLimit(int xLimit) {
        this.xLimit = xLimit;
    }

    public int getyLimit() {
        return yLimit;
    }

    private void setyLimit(int yLimit) {
        this.yLimit = yLimit;
    }
}
