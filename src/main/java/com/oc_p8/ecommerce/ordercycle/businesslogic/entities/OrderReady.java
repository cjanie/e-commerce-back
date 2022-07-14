package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

public class OrderReady extends DecoratorOrderInProcess {

    public OrderReady(Order order, String assignee) {
        super(order, assignee);
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
