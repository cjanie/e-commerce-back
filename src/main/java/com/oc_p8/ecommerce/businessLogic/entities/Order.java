package com.oc_p8.ecommerce.businessLogic.entities;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.businessLogic.enums.OrderState;
import com.oc_p8.ecommerce.businessLogic.enums.PaymentStatus;

public class Order {

    private Client client;

    private List<String> products = new ArrayList<>();

    private OrderState state;

    private PaymentStatus paymentStatus;

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public PaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
