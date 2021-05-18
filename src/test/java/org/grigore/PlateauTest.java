package org.grigore;

import junit.framework.TestCase;

public class PlateauTest extends TestCase {

    public void testSingleton() {
        Plateau plateau1 = Plateau.getInstance(1, 2);
        Plateau plateau2 = Plateau.getInstance();
        assertSame(plateau1, plateau2);
    }

    public void testGetxLimit() {
        Plateau plateau = Plateau.getInstance(1, 2);
        assertEquals(plateau.getxLimit(), 1);
    }

    public void testGetyLimit() {
        Plateau plateau = Plateau.getInstance(1, 2);
        assertEquals(plateau.getyLimit(), 2);
    }

    public void testConstructorWithArgumentsWithoutDelete() {
        Plateau plateau1 = Plateau.getInstance(1, 2);
        Plateau plateau2 = Plateau.getInstance(2, 3);
        assertTrue(plateau2.getxLimit() == 1 && plateau2.getyLimit() == 2);
    }
    public void testConstructorWithArgumentsWithDelete() {
        Plateau plateau1 = Plateau.getInstance(1, 2);
        Plateau.deleteInstance();
        Plateau plateau2 = Plateau.getInstance(2, 3);
        assertTrue(plateau2.getxLimit() == 2 && plateau2.getyLimit() == 3);
    }

}