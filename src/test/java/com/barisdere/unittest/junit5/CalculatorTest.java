package com.barisdere.unittest.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("production")
@DisplayName("Test calculation methods")
class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("I perform topla with 2 positive numbers and result must be positive")
    public void testWhenIPerformAdditionWithPositiveNumbersThenResultsIsPositive() {
        int nr1 = 5;
        int nr2 = 8;
        int expectedResult = 13;

        int result = calculator.topla(nr1, nr2);

        assertEquals(expectedResult, result);
    }

    @Test
    @Tag("development")
    public void testAddition2() {
        int result = calculator.topla(5, 8);

        assertEquals(13, result);
    }

    @Test
    public void testAdditionOfPositiveNumbersResultInPositiveNumbers() {
        assertEquals(13, calculator.topla(2, 8), "Addition of positive numbers should result in positive numbers");
    }

    @Test
    public void testAddition4() {
//        assertEquals(13, calculator.topla(5, 8));
//        assertEquals(13, calculator.topla(4, 8));
//        assertEquals(13, calculator.topla(3, 8));
//        assertEquals(13, calculator.topla(2, 8));
//        assertEquals(13, calculator.topla(1, 8));

        assertAll(
                () -> assertEquals(13, calculator.topla(5, 8)),
                () -> assertEquals(13, calculator.topla(4, 8)),
                () -> assertEquals(13, calculator.topla(3, 8)),
                () -> assertEquals(13, calculator.topla(2, 8)),
                () -> assertEquals(13, calculator.topla(1, 8))
        );
    }
}