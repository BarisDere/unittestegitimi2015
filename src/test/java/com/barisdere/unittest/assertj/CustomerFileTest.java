package com.barisdere.unittest.assertj;

import com.barisdere.unittest.customer.exception.MailServerUnavailableException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;

/**
 * Created by baris on 15/03/15.
 */
public class CustomerFileTest {

    @Test
    public void testFiles() throws Exception {

        File file = new File("/Kullanıcı Bilgileri/test.txt");

        assertThat(file)
                .exists()
                .canRead()
                .canWrite()
                .hasExtension("txt")
                .hasName("test.txt");

        assertThat(contentOf(file))
                .startsWith("Lorem");

    }

    @Test
    public void testException() throws Exception {

        Exception exception = new MailServerUnavailableException("this is a test");

        assertThat(exception)
                .hasMessage("this is a test")
                .isInstanceOf(MailServerUnavailableException.class)
                .hasMessageContaining("is a");


    }
}
