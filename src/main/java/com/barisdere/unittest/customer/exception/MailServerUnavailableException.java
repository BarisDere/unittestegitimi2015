package com.barisdere.unittest.customer.exception;

/**
 * Created by baris on 10/03/15.
 */
public class MailServerUnavailableException extends RuntimeException {

    public MailServerUnavailableException(String message) {
        super(message);
    }
}
