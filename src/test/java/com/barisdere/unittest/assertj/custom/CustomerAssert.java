package com.barisdere.unittest.assertj.custom;

import com.barisdere.unittest.assertj.CustomAssertTest;
import com.barisdere.unittest.assertj.Customer;
import com.barisdere.unittest.assertj.CustomerRepository;
import com.barisdere.unittest.assertj.NotificationService;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by baris on 15/03/15.
 */
public class CustomerAssert extends AbstractAssert<CustomerAssert, Customer> {

    private CustomerRepository customerRepository;
    private NotificationService notificationService;

    public CustomerAssert(Customer actual, Class<?> selfType, CustomerRepository customerRepository, NotificationService notificationService) {
        super(actual, selfType);
        this.customerRepository = customerRepository;
        this.notificationService = notificationService;
        isNotNull();
    }


    public CustomerAssert hasGifts(int sizeOfGifts) {

        assertThat(actual.getGifts())
                .isNotEmpty()
                .hasSize(sizeOfGifts);

        return this;
    }

    public CustomerAssert hasGiftWithName(String giftName) {

        assertThat(actual.getGifts())
                .isNotEmpty()
                .extracting("name")
                    .contains(giftName);

        return this;
    }

    public CustomerAssert isSaved() {

        Mockito.verify(customerRepository).save(Mockito.any(Customer.class));

        return this;
    }

    public CustomerAssert hasReceivedWelcomeNotification() {

        Mockito.verify(notificationService).sendWelcomeNotification(CustomAssertTest.USERNAME, CustomAssertTest.EMAIL);

        return this;
    }
}
