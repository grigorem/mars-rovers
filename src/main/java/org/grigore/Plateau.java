package org.grigore;

import java.util.ArrayList;

public class Plateau {
    private int xLimit;
    private int yLimit;
    private static Plateau plateau = null;
    private ArrayList<Rover> rovers = new ArrayList<>();

    /* constructors */
    private Plateau(int x, int y) {
        setxLimit(x);
        setyLimit(y);
    }

    /* public methods */
    public static Plateau getInstance(int x, int y) {
        if (plateau == null) {
            plateau = new Plateau(x, y);
        }
        return plateau;
    }

    public static Plateau getInstance() {
        if (plateau == null) {
            plateau = new Plateau(0, 0); // create an empty plateau
        }
        return plateau;
    }

    public static void deleteInstance() {
        plateau = null;
    }

    public void addRover(Rover rover) {
        rovers.add(rover);
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

    public ArrayList<Rover> getRovers() {
        return rovers;
    }

    public void setRovers(ArrayList<Rover> rovers) {
        this.rovers = rovers;
    }
}
