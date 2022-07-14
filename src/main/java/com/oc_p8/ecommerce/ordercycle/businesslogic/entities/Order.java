package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

public abstract class Order {

    protected Long id;

    protected Client client;

    protected Cart cart;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getHistoric() {
        return "Initial State " + this.state() + ".";
    }

    public abstract OrderState state();

}
