package com.barisdere.unittest.assertj;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {

    private String username;

    private String email;

    private List<Gift> gifts = new ArrayList<Gift>();

    public void addGift(Gift gift) {
        gifts.add(gift);
    }

    public Customer(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
