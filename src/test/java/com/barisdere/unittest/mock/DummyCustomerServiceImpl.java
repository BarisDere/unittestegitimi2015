package com.barisdere.unittest.mock;

/**
 * Created by baris on 19/03/15.
 */
public class DummyCustomerServiceImpl implements DummyCustomerService {
    @Override
    public void addCustomer(String customerName) {
        System.out.println("addCustomer(" + customerName + ")");
    }

    @Override
    public void removeCustomer(String customerName) {
        System.out.println("removeCustomer(" + customerName + ")");

    }

    @Override
    public void updateCustomer(String customerName) {
        System.out.println("updateCustomer(" + customerName + ")");

    }

    @Override
    public String getCustomer(String customerName) {
        return "getCustomer(" + customerName + ")";
    }
}
