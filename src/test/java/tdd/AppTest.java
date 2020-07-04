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

    @Test
    public void testAdd1()
    {
        String numbersStr = "0";
        assertEquals(0, sc.add(numbersStr));
    }

    @Test
    public void testAdd2()
    {
        String numbersStr = "1";
        assertEquals(1, sc.add(numbersStr));
    }

    @Test
    public void testAdd3()
    {
        String numbersStr = "1,2";
        assertEquals(3, sc.add(numbersStr));
    }

    @Test
    public void testAdd4()
    {
        String numbersStr = "1,2,2,46,73,1,0,64,8";
        assertEquals(197, sc.add(numbersStr));
    }

    @Test
    public void testAdd5()
    {
        String numbersStr = "1,2,,2,46,73,1,0,64,8";
        assertEquals(197, sc.add(numbersStr));
    }

    @Test
    public void testAdd6()
    {
        String numbersStr = "1,2, ,2,46,73,1,0,64,8";
        assertEquals(197, sc.add(numbersStr));
    }

}
