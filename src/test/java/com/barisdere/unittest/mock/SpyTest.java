package com.barisdere.unittest.mock;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created by baris on 19/03/15.
 */
public class SpyTest {

    @Test
    public void testSpy() throws Exception {

        DummyCustomerService service = spy(new DummyCustomerServiceImpl());
        doNothing().when(service).addCustomer(eq("istanbul"));  //sadece istanbul icin gecerli
//        doThrow(new IllegalArgumentException()).when(service).removeCustomer(anyString());

        doNothing().when(service).removeCustomer("istanbul1");
        doNothing().when(service).removeCustomer("istanbul2");
//        doCallRealMethod().when(service).removeCustomer("istanbul3");  //default olarak gercek method cagirilir

        service.removeCustomer("istanbul1");
        service.removeCustomer("istanbul2");
        service.removeCustomer("istanbul3");  //ekrana yazilmasi bekleniyor


    }
}
