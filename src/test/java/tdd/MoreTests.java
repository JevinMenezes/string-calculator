package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MoreTests {
    @Test
    public static void testArray() {
        int[] array1 = new int[]{0,1,2,3,4};
        int[] array2 = new int[]{0,1,2,3,4};
        assertEquals(array1, array2);
    }

}