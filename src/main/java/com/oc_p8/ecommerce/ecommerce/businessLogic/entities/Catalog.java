package com.oc_p8.ecommerce.ecommerce.businessLogic.entities;


import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private Long id;

    private List<Item> items;

    public Catalog() {
        this.items = new ArrayList();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
