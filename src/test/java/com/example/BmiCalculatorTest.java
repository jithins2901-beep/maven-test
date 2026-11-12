package com.example;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BmiCalculatorTest {

    BmiCalculator bmi = new BmiCalculator();

    @Test
    public void testCalculateBMI() {
        assertEquals(25.00, bmi.calculateBMI(70, 1.75), 0.01);
    }

    @Test
    public void testUnderweight() {
        assertEquals("Underweight", bmi.getCategory(18.4));
    }

    @Test
    public void testNormal() {
        assertEquals("Normal", bmi.getCategory(18.5));
    }

    @Test
    public void testOverweight() {
        assertEquals("Overweight", bmi.getCategory(25));
    }

    @Test
    public void testObese() {
        assertEquals("Obese", bmi.getCategory(30));
    }

    @Test
    public void testZeroWeight() {
        assertThrows(IllegalArgumentException.class,
                () -> bmi.calculateBMI(0, 1.75));
    }

    @Test
    public void testNegativeWeight() {
        assertThrows(IllegalArgumentException.class,
                () -> bmi.calculateBMI(-70, 1.75));
    }

    @Test
    public void testZeroHeight() {
        assertThrows(IllegalArgumentException.class,
                () -> bmi.calculateBMI(70, 0));
    }

    @Test
    public void testNegativeHeight() {
        assertThrows(IllegalArgumentException.class,
                () -> bmi.calculateBMI(70, -1.75));
    }

    @Test
    public void testExtremeWeight() {
        assertThrows(IllegalArgumentException.class,
                () -> bmi.calculateBMI(600, 1.75));
    }

    @Test
    public void testExtremeHeight() {
        assertThrows(IllegalArgumentException.class,
                () -> bmi.calculateBMI(70, 3.5));
    }
}

