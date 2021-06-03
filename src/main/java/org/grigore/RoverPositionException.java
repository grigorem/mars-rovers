package org.grigore;

public class RoverPositionException extends Exception {
    public RoverPositionException(String message) {
        super("Initial rover position is invalid: " + message);
    }
}
