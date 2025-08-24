package myFirstProject.raman.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {

    private final Addition addition = new Addition();

    @Test
    void testAddPositiveNumbers() {
        int result = addition.add(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    void testAddNegativeNumbers() {
        int result = addition.add(-4, -6);
        assertEquals(-10, result, "-4 + -6 should equal -10");
    }

    @Test
    void testAddPositiveAndNegative() {
        int result = addition.add(10, -3);
        assertEquals(7, result, "10 + -3 should equal 7");
    }

    @Test
    void testAddZero() {
        int result = addition.add(0, 5);
        assertEquals(5, result, "0 + 5 should equal 5");
    }
}
