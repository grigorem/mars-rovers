package org.grigore;

import org.junit.Assert;
import org.junit.Test;

public class PlateauTest {

    @Test
    public void testSingleton() {
        Plateau plateau1 = Plateau.getInstance(1, 2);
        Plateau plateau2 = Plateau.getInstance();
        Assert.assertSame(plateau1, plateau2);
    }

    @Test
    public void testGetxLimit() {
        Plateau plateau = Plateau.getInstance(1, 2);
        Assert.assertEquals(plateau.getxLimit(), 1);
    }

    @Test
    public void testGetyLimit() {
        Plateau plateau = Plateau.getInstance(1, 2);
        Assert.assertEquals(plateau.getyLimit(), 2);
    }

    @Test
    public void testConstructorWithArgumentsWithoutDelete() {
        Plateau plateau1 = Plateau.getInstance(1, 2);
        Plateau plateau2 = Plateau.getInstance(2, 3);
        Assert.assertTrue(plateau2.getxLimit() == 1 && plateau2.getyLimit() == 2);
    }

    @Test
    public void testConstructorWithArgumentsWithDelete() {
        Plateau plateau1 = Plateau.getInstance(1, 2);
        Plateau.deleteInstance();
        Plateau plateau2 = Plateau.getInstance(2, 3);
        Assert.assertTrue(plateau2.getxLimit() == 2 && plateau2.getyLimit() == 3);
    }

}