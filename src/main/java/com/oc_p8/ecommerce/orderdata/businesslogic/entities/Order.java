package com.oc_p8.ecommerce.orderdata.businesslogic.entities;

public class Order {

    private Long id;

    private Client client;

    private Cart cart;

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

}
