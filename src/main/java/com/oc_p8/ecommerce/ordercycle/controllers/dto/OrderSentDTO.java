package com.oc_p8.ecommerce.ordercycle.controllers.dto;

import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Cart;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Client;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;

public class OrderSentDTO {

    private Long id;

    private String clientFirstName;

    private String clientLastName;

    private List<String> items;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientFirstName() {
        return this.clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return this.clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public List<String> getItems() {
        return this.items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public OrderAtReceipt format() {
        OrderAtReceipt orderAtReceipt = new OrderAtReceipt();
        orderAtReceipt.setId(this.id);
        Client client = new Client();
        client.setFirstName(this.clientFirstName);
        client.setLastName(this.clientLastName);
        orderAtReceipt.setClient(client);
        Cart cart = new Cart();
        cart.setItems(this.items);
        orderAtReceipt.setCart(cart);
        return orderAtReceipt;
    }

}
