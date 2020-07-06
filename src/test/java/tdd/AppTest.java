package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppTest {
    static StringCalculator sc = null;

    @BeforeAll
    public static void setUp() {
        sc = new StringCalculator();
    }

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
        Throwable exception = assertThrows(NumberFormatException.class, () -> sc.add(numbersStr));
        assertTrue(exception.getMessage().contains("For input string: \"a\""));
    }
    
    @Test
    public void testAdd8()
    {
        String numbersStr = "1,02,1.0,2,46.53,73.5995,1,0,64,8";
        Throwable exception = assertThrows(NumberFormatException.class, () -> sc.add(numbersStr));
        assertTrue(exception.getMessage().contains("For input string: \"1.0\""));
    }
    
    @Test
    public void testAdd9()
    {
        String numbersStr = "1,2,2,46,73,-1,0,64,8";
        Throwable exception = assertThrows(NumberFormatException.class, () -> sc.add(numbersStr));
        assertTrue(exception.getMessage().contains("negatives not allowed"));
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

    @Test
    public void testAdd12()
    {
        String numbersStr = "//;\n1;2";
        assertEquals(3, sc.add(numbersStr));
    }

    @Test
    public void testAdd13()
    {
        String numbersStr = "1,2,2,46,73,-1,0,64,8";
        Throwable exception = assertThrows(NumberFormatException.class, () -> sc.add(numbersStr));
        assertTrue(exception.getMessage().contains("negatives not allowed : -1"));
    }
    
    @Test
    public void testAdd14()
    {
        String numbersStr = "1,2,2,46,73,-1,0,64,-8";
        Throwable exception = assertThrows(NumberFormatException.class, () -> sc.add(numbersStr));
        assertTrue(exception.getMessage().contains("negatives not allowed : -1,-8"));
    }

    @AfterAll
    public static void testAdd15()
    {
        assertEquals(17, sc.getCalledCount());
    }

    @Test
    public void testAdd16()
    {
        String numbersStr = "1,2,2,1001,46,73,1000,64";
        assertEquals(1188, sc.add(numbersStr));
    }

    @Test
    public void testAdd17()
    {
        String numbersStr = "//[***]\n1***2***3";
        assertEquals(6, sc.add(numbersStr));
    }
}
