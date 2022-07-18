package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

public class OrderFactory {

    public Order createOrder(Long id) {
        return this.createOrderAtReceipt(id);
    }

    public OrderAtReceipt createOrderAtReceipt(Long id) {
        return new OrderAtReceipt(id);
    }

    public OrderInPreparation createOrderInPreparation(Long id, String assignee) {
        Order order = this.createOrderAtReceipt(id);
        order = new OrderInPreparation(order, assignee);
        return (OrderInPreparation) order;
    }

    public OrderReady createOrderReady(OrderInPreparation order, String assignee) {
        OrderReady orderReady = new OrderReady(order, assignee);
        return orderReady;
    }

}
