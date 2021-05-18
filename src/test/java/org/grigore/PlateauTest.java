package org.grigore;

import junit.framework.TestCase;

public class PlateauTest extends TestCase {

    public void testSingleton() {
        Plateau plateau1 = Plateau.getInstance(1, 2);
        Plateau plateau2 = Plateau.getInstance(2, 3);
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
}