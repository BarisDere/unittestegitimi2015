package com.barisdere.unittest.mock;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by baris on 19/03/15.
 */
public class OnAsamaTest {

    @Test
    public void testWhen() throws Exception {

        DummyCustomerService service = mock(DummyCustomerService.class);
        when(service.getCustomer(eq("istanbul"))).thenReturn("customerIstanbul"); //ankara parametre veririlirse calisiyor

        String customer = service.getCustomer("istanbul");

        assertThat(customer).isEqualTo("customerIstanbul");

    }

    @Test
    public void testWhen2() throws Exception {

        DummyCustomerService service = mock(DummyCustomerService.class);
        when(service.getCustomer(eq("istanbul"))).thenThrow(new RuntimeException()); //ankara verilince exception atiyor

        String customer = service.getCustomer("istanbul");

    }

    @Test
    public void testWhen3() throws Exception {

        //void geri veren methodlar nasil when kullanir?

        DummyCustomerService service = mock(DummyCustomerService.class);

        // tam tersi yazilan do ile baslayan methodlar

        doNothing().when(service).addCustomer(anyString());
        doThrow(new RuntimeException()).when(service).addCustomer(anyString());


        //ayni return when burada yazilabilir
        doReturn("ankara").when(service).getCustomer("istanbul");


    }
}
