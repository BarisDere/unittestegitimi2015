package com.barisdere.unittest.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Calculator Display test")
class CalculatorDisplayNameTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testPozitifSayilarToplanincaPozitifCikar() {
        int result = calculator.topla(4, 8);

        assertEquals(13, result);
    }

    @Test
    public void testNegatifSayilarCarpilincaPozitifCikar() {
        int result = calculator.carp(-5, -8);

        assertEquals(40, result);
    }

}