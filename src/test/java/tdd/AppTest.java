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

    @Test
    public void testAdd7()
    {
        String numbersStr = "1,2,a,2,46,73,1,0,64,8";
        assertEquals(197, sc.add(numbersStr));
    }
    
    @Test
    public void testAdd8()
    {
        String numbersStr = "1,02,1.0,2,46.53,73.5995,1,0,64,8";
        assertEquals(78, sc.add(numbersStr));
    }
    
    @Test
    public void testAdd9()
    {
        String numbersStr = "1,2,2,46,73,-1,0,64,8";
        assertEquals(196, sc.add(numbersStr));
    }
        
    @Test
    public void testAdd10()
    {
        Integer[] numbers = {1,2,2,46,73,1,0,64,8};
        assertEquals(197, sc.add(numbers));
    }

    @Test
    public void testAdd11()
    {
        String numbersStr = "1\n2,3";
        assertEquals(6, sc.add(numbersStr));
    }
}
