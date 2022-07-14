package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;

public class OrderInPreparation extends DecoratorOrderInProcess {

    public OrderInPreparation(Order order, String assignee) {
        super(order, assignee);
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
