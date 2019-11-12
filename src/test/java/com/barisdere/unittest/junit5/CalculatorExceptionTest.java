package com.barisdere.unittest.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("dev")
public class CalculatorExceptionTest {

    @Test
    public void testExceptions() {

        Calculator calculator = new Calculator();

        ArithmeticException exception = assertThrows(
                ArithmeticException.class, () -> calculator.bol(1, 0)
        );

        assertEquals("/ by zero", exception.getMessage());
    }

}
