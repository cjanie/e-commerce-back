package com.oc_p8.ecommerce.ordercycle.controllers.dto;

import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;

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
        Order orderAtReceipt = new OrderFactory().createOrder(this.id);
        orderAtReceipt.setId(this.id);
        return (OrderAtReceipt) orderAtReceipt;
    }

}
