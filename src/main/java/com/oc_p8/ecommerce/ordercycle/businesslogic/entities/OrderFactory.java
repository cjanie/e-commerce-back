package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderStateVisitor;

public class OrderFactory {

    public Order createOrder(Long id) {
        return this.createOrder(id, OrderState.RECEIPT, null);
    }

    public Order createOrder(Long id, OrderState state, String assignee) {

        return state.accept(new OrderStateVisitor<Order>() {

            @Override
            public Order visitReceipt() {
                Order order = new OrderAtReceipt();
                order.setId(id);
                return order;
            }

            @Override
            public Order visitPreparation() {
                return OrderInPreparationFactory.getInstance().createOrderInPreparation(id, assignee);
            }

            @Override
            public Order visitReady() {
                // TODO OrderReadyFactory Auto-generated method stub
                Order order = OrderInPreparationFactory.getInstance().createOrderInPreparation(id, assignee);
                order = new OrderReady(order, assignee);
                return order;
            }

        });
    }
}
