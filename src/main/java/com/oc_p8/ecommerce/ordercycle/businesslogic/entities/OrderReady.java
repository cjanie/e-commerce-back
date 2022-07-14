package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

public class OrderReady extends DecoratorOrderInProcess {

    private Order order;
    private String assignee;

    public OrderReady(Order order, String assignee) {
        this.order = order;
        this.assignee = assignee;
        this.id = order.getId();
        this.client = order.getClient();
        this.cart = order.getCart();
    }

    @Override
    public OrderState state() {
        return OrderState.READY;
    }

    public String assignee() {
        return this.assignee;
    }

    @Override
    public String getHistoric() {
        return this.order.getHistoric() + " New State " + this.state() + " by Assignee " + this.assignee() + ".";
    }

}
