package com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities;

import java.util.HashSet;
import java.util.Set;

public class Catalog {

    private Long id;

    private Set<Item> items;

    public Catalog() {
        this.items = new HashSet<>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return this.items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

}
