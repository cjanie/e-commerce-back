package com.oc_p8.ecommerce.orderdata.businesslogic.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<String> items = new ArrayList<>();

    public List<String> getItems() {
        return this.items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

}
