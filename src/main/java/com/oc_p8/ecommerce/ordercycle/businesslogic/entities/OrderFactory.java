package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderStateVisitor;

public class OrderFactory {

    public Order createOrder(Long id) {
        return this.createOrderAtReceipt(id);
    }

    public Order createOrder(Long id, OrderState state, String assignee) {

        return state.accept(new OrderStateVisitor<Order>() {

            @Override
            public Order visitReceipt() {
                return createOrderAtReceipt(id);
            }

            @Override
            public Order visitPreparation() {
                return createOrderInPreparation(id, getAssigneeAsArray(assignee)[0]);
            }

            @Override
            public Order visitReady() {
                return createOrderReady(id, getAssigneeAsArray(assignee)[0], getAssigneeAsArray(assignee)[1]);
            }

        });
    }

    private OrderAtReceipt createOrderAtReceipt(Long id) {
        Order order = new OrderAtReceipt();
        order.setId(id);
        return (OrderAtReceipt) order;
    }

    private OrderInPreparation createOrderInPreparation(Long id, String assignee) {
        Order order = this.createOrderAtReceipt(id);
        order = new OrderInPreparation(order, assignee);
        return (OrderInPreparation) order;
    }

    private OrderReady createOrderReady(Long id, String assignee0, String assignee1) {
        Order order = this.createOrderInPreparation(id, assignee0);
        order = new OrderReady(order, assignee1);
        return (OrderReady) order;
    }

    private String[] getAssigneeAsArray(String assignee) {
        return assignee.split(",");
    }
}
