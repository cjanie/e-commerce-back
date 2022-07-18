package com.oc_p8.ecommerce.orderdata.businesslogic.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Long> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<Long> getItems() {
        return this.items;
    }

    public void setItems(List<Long> items) {
        this.items = items;
    }

}
