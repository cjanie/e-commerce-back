package com.oc_p8.ecommerce.ecommerce.businessLogic.entities;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private Long id;

    private List<StockItem> items;

    public Stock() {
        this.items = new ArrayList<>();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StockItem> getItems() {
        return this.items;
    }

    public void setItems(List<StockItem> items) {
        this.items = items;
    }


}
