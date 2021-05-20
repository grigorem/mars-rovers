package org.grigore;

import junit.framework.TestCase;

public class CommandProcessorTest extends TestCase {

    public void testProcessCommand() {
        Plateau.deleteInstance();
        String expected = "1 3 N" + System.lineSeparator() + "5 1 E";
        String input = "5 5" + System.lineSeparator() +
                "1 2 N" + System.lineSeparator() +
                "LMLMLMLMM" + System.lineSeparator() +
                "3 3 E" + System.lineSeparator() +
                "MMRMMRMRRM" + System.lineSeparator();
        String actual = CommandProcessor.process(input);
        assertEquals(actual, expected);
    }
}