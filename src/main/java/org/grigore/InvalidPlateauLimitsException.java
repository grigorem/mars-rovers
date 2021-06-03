package org.grigore;

public class InvalidPlateauLimitsException extends Exception {
    public InvalidPlateauLimitsException(String message) {
        super("Invalid Plateau limits (should be integer greater than 0): " + message);
    }
}
