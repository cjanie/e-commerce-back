package com.oc_p8.ecommerce.ordercycle.infrastructure.factories;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderStateVisitor;

public class VisitorOrderFactory<E> {

    private OrderFactory orderFactory;

    public VisitorOrderFactory() {
        this.orderFactory = new OrderFactory();
    }

    public Order createOrder(Long id, OrderState state, String assignee) {
        return state.accept(new OrderStateVisitor<Order>() {

            @Override
            public Order visitReceipt() {
                return orderFactory.createOrderAtReceipt(id);
            }

            @Override
            public Order visitPreparation() {
                return orderFactory.createOrderInPreparation(id, formatAssigneeToArray(assignee)[0]);
            }

            @Override
            public Order visitReady() {
                return createOrderReady(id, formatAssigneeToArray(assignee)[0],
                        formatAssigneeToArray(assignee)[1]);
            }

        });

    }

    private OrderReady createOrderReady(Long id, String assignee0, String assignee1) {
        Order order = this.orderFactory.createOrderInPreparation(id, assignee0);
        order = this.orderFactory.createOrderReady((OrderInPreparation) order, assignee1);
        return (OrderReady) order;
    }

    private String[] formatAssigneeToArray(String assignee) {
        return assignee.split(",");
    }

}
