package tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AppTest 
{
    StringCalculator sc = null;

    @Before
    public void setUp() {sc = new StringCalculator();}

    @Test
    public void testAdd()
    {
        String numbersStr = "";
        assertEquals(0, sc.add(numbersStr));
    }

}
