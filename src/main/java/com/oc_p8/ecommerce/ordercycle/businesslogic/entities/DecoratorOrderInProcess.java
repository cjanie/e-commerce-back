package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

public abstract class DecoratorOrderInProcess extends Order {

    protected Order order;
    protected String assignee;

    public DecoratorOrderInProcess(Order order, String assignee) {
        this.order = order;
        this.assignee = assignee;
        this.id = order.getId();
    }

    public abstract String getHistoric();
}
