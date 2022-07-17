package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

public class OrderReady extends DecoratorOrderInProcess {

    OrderReady(Order order, String assignee) {
        super(order, assignee);
    }

    @Override
    public OrderState state() {
        return OrderState.READY;
    }

    public String assignees() {
        String assignees = ((OrderInPreparation) this.order).assignee() + "," + this.assignee;
        return assignees;
    }

    @Override
    public String getHistoric() {
        String[] assignees = this.assignees().split(",");
        return this.order.getHistoric() + " New State " + this.state() + " by " + assignees[1] + ".";
    }

}
