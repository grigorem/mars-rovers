package org.grigore;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

public class PlateauTest {

    @Test
    public void testSingleton() {
        Plateau.deleteInstance();
        Plateau plateau1 = null;
        try {
            plateau1 = Plateau.getInstance(1, 2);
        } catch (InvalidPlateauLimitsException e){
            fail();
        }
        Plateau plateau2 = Plateau.getInstance();
        Assert.assertSame(plateau1, plateau2);
    }

    @Test
    public void testGetxLimit() {
        Plateau.deleteInstance();
        Plateau plateau = null;
        try {
            plateau = Plateau.getInstance(1, 2);
        } catch (InvalidPlateauLimitsException e){
            fail();
        }
        Assert.assertEquals(plateau.getxLimit(), 1);
    }

    @Test
    public void testGetyLimit() {
        Plateau.deleteInstance();
        Plateau plateau = null;
        try {
            plateau = Plateau.getInstance(1, 2);
        } catch (InvalidPlateauLimitsException e){
            fail();
        }
        Assert.assertEquals(plateau.getyLimit(), 2);
    }

    @Test
    public void testConstructorWithArgumentsWithoutDelete() {
        Plateau.deleteInstance();
        try {
            Plateau.getInstance(1, 2);
        } catch (InvalidPlateauLimitsException e){
            fail();
        }
        Plateau plateau2 = null;
        try {
            plateau2 = Plateau.getInstance(2, 3);
        } catch (InvalidPlateauLimitsException e){
            fail();
        }
        Assert.assertTrue(plateau2.getxLimit() == 1 && plateau2.getyLimit() == 2);
    }

    @Test
    public void testConstructorWithArgumentsWithDelete() {
        Plateau.deleteInstance();
        try {
            Plateau.getInstance(1, 2);
        } catch (InvalidPlateauLimitsException e){
            fail();
        }
        Plateau.deleteInstance();
        Plateau plateau2 = null;
        try {
            plateau2 = Plateau.getInstance(2, 3);
        } catch (InvalidPlateauLimitsException e){
            fail();
        }
        Assert.assertTrue(plateau2.getxLimit() == 2 && plateau2.getyLimit() == 3);
    }

}