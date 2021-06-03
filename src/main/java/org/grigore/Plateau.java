package org.grigore;

import java.util.ArrayList;

public class Plateau {
    private int xLimit;
    private int yLimit;
    private static Plateau plateau = null;
    private ArrayList<Rover> rovers = new ArrayList<>();

    /* constructors */
    private Plateau(int x, int y) throws InvalidPlateauLimitsException {
        if (x <= 0) {
            throw new InvalidPlateauLimitsException("X = " + x);
        }
        if (y <= 0) {
            throw new InvalidPlateauLimitsException("Y = " + y);
        }

        setxLimit(x);
        setyLimit(y);
    }

    /* public methods */
    public static Plateau getInstance(int x, int y) throws InvalidPlateauLimitsException {
        if (plateau == null) {
            plateau = new Plateau(x, y);
        }
        return plateau;
    }

    public static Plateau getInstance() {
        if (plateau == null) {
            try {
                plateau = new Plateau(10, 10); // create a 10 by 10 plateau
            } catch (InvalidPlateauLimitsException e) {
                // do nothing
            }
        }
        return plateau;
    }

    public static void deleteInstance() {
        plateau = null;
    }

    public void addRover(Rover rover) throws RoverPositionException {
        for (Rover existingRover : rovers) {
            if ((existingRover.getY() == rover.getY()
                    && existingRover.getX() == rover.getX())) {
                throw new RoverPositionException("Initial position of rover is the same with an existing rover");
            }
        }
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
