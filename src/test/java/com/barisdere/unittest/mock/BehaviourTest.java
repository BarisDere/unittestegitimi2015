package com.barisdere.unittest.mock;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

/**
 * Created by baris on 19/03/15.
 */
public class BehaviourTest {

    @Test
    public void testBehavior() throws Exception {

        DummyCustomerService customerService = mock(DummyCustomerService.class);

        customerService.addCustomer("istanbul");
        customerService.addCustomer("ankara");

        verify(customerService).addCustomer("istanbul");
        verify(customerService).addCustomer("ankara");
    }

    @Test
    public void testKacKereCagirildi() throws Exception {
        DummyCustomerService customerService = mock(DummyCustomerService.class);

        customerService.addCustomer("istanbul");
        customerService.addCustomer("istanbul");
        customerService.addCustomer("ankara");
        customerService.addCustomer("istanbul");

        //3 kere addCustomer(istanbul) cagirildi
        verify(customerService, times(3)).addCustomer("istanbul");
        verify(customerService, times(1)).addCustomer("ankara");  //times(1) default

        //removeCustomer hic bir zaman cagirilmadi, parametre farketmez
        verify(customerService, never()).removeCustomer(anyString());

        verify(customerService, never()).addCustomer("izmir");  //hic cagirilmadi


        //en kaz 2 defa cagirildi
        verify(customerService, atLeast(1)).addCustomer("ankara");
    }

    @Test
    public void testSirasiniKontrolEt() throws Exception {

        //verildigi sirada cagirilsin
        DummyCustomerService customerService = mock(DummyCustomerService.class);

        customerService.addCustomer("istanbul");
        customerService.addCustomer("ankara");
        customerService.updateCustomer("izmir");

        InOrder inOrder = inOrder(customerService);     //istedigimiz kadar mock nesneleri verebiliriz

        inOrder.verify(customerService).addCustomer("ankara");      //2
        inOrder.verify(customerService).updateCustomer("izmir");    //3
        inOrder.verify(customerService).addCustomer("istanbul");    //1
    }

    @Test
    public void testBaskaKontrolYok() throws Exception {

        DummyCustomerService customerService = mock(DummyCustomerService.class);
        DummyCustomerService customerService2 = mock(DummyCustomerService.class);

        customerService.addCustomer("istanbul");
        customerService.removeCustomer("ankara");
        customerService2.addCustomer("izmir");


        verify(customerService).addCustomer("istanbul");
        verify(customerService).removeCustomer("ankara");

        verifyZeroInteractions(customerService2);  //hic cagirilmasin
    }
}
