package org.grigore;

import java.util.ArrayList;

public class Mars {
    Plateau plateau;
    ArrayList<Rover> rovers;

    /* public methods */
    public void addRover(Rover rover) {
        rovers.add(rover);
    }

    /* default getters and setters */
    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public ArrayList<Rover> getRovers() {
        return rovers;
    }

    public void setRovers(ArrayList<Rover> rovers) {
        this.rovers = rovers;
    }
}
