package com.barisdere.unittest.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("acceptance")
public class CalculatorParameterizedTest {

    @ParameterizedTest(name = "When I perform topla with numbers {0} and {1}, then result is {2}")
    @MethodSource("positiveTestNumbers")
    public void testParameters(int nr1, int nr2, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.topla(nr1, nr2));
    }

    private static Stream<Arguments> positiveTestNumbers() {
        return Stream.of(
          Arguments.of(1, 1, 2),
          Arguments.of(1, 2, 3),
          Arguments.of(1, 3, 4),
          Arguments.of(1, 4, 5),
          Arguments.of(1, 5, 6),
          Arguments.of(1, 6, 7),
          Arguments.of(1, 7, 8),
          Arguments.of(1, 8, 9)
        );
    }
}
