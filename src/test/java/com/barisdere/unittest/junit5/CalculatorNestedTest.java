package com.barisdere.unittest.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("test")
@DisplayName("Test with nested test support")
public class CalculatorNestedTest {

    private Calculator calculator = new Calculator();

    @Nested
    @DisplayName("Test with positive numbers")
    class PositiveNumbers {

        @Test
        public void testWhenPositiveNumbersAddedResultIsPositive() {
            assertEquals(13, calculator.topla(5, 8));
        }
    }

    @Nested
    @DisplayName("Test with negative numbers")
    class NegativeNumbers {

        @Test
        @Tag("performance")
        public void testWhenNegativeNumbersAddedResultIsNegative() {
            assertEquals(-13, calculator.topla(-4, -8));
        }

        @Test
        public void testWhenNegativeNumbersAddedResultIsNegative2() {
            assertEquals(-10, calculator.topla(-5, -5));
        }
    }
}
