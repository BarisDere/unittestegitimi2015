package com.barisdere.unittest.customer;

import com.barisdere.unittest.customer.exception.MailServerUnavailableException;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static com.googlecode.catchexception.apis.CatchExceptionHamcrestMatchers.*;
import static org.junit.Assert.*;

import com.googlecode.catchexception.CatchException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by baris on 10/03/15.
 */
public class ExceptionTest {

    private BilgilendirmeService bilgilendirmeService = new BilgilendirmeService();

    @Test
    public void testTryCatchException() {
        try {
            bilgilendirmeService.haftalikMailGonder();
        } catch (Exception ex) {
            assertTrue(ex instanceof MailServerUnavailableException);
            assertEquals("mail server hata veriyor", ex.getMessage());
        }
    }

    @Test(expected = MailServerUnavailableException.class)
    public void testExpectedException() throws Exception {
        bilgilendirmeService.haftalikMailGonder();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRuleException() throws Exception {
        thrown.expect(MailServerUnavailableException.class);
        thrown.expectMessage("mail server hata veriyor");

        bilgilendirmeService.haftalikMailGonder();
    }

    @Test
    public void testCatchExceptionFramework() throws Exception {

        catchException(bilgilendirmeService).haftalikMailGonder();

        assertTrue(caughtException() instanceof MailServerUnavailableException);
        assertEquals("mail server hata veriyor", caughtException().getMessage());
    }



}