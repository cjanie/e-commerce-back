package com.oc_p8.ecommerce.ecommerce.process.businessLogic.entities;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ecommerce.process.businessLogic.enums.OrderState;

public class Order {
    
    private Long id;

    private List<String> products = new ArrayList<>();

    private OrderState state;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getProducts() {
        return this.products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public OrderState getState() {
        return this.state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
}
