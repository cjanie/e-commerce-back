package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

public class OrderInPreparation extends DecoratorOrderInProcess {

    private Order order;
    private String assignee;

    public OrderInPreparation(Order order, String assignee) {
        this.order = order;
        this.assignee = assignee;
        this.id = this.order.getId();
        this.client = this.order.getClient();
        this.cart = this.order.getCart();
    }

    @Override
    public OrderState state() {
        return OrderState.PREPARATION;
    }

    public String assignee() {
        return this.assignee;
    }

    @Override
    public String getHistoric() {
        return this.order.getHistoric() + " New State " + this.state().toString() + " by Assignee "
                + this.assignee() + ".";
    }

}
