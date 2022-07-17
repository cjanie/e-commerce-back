package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderStateVisitor;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries.GetOrderByIdUseCase;

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
                return createOrderInPreparation(id, formatAssigneeToArray(assignee)[0]);
            }

            @Override
            public Order visitReady() {
                return createOrderReady(id, formatAssigneeToArray(assignee)[0], formatAssigneeToArray(assignee)[1]);
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

    private OrderReady createOrderReady(Long id, GetOrderByIdUseCase getOrderByIdUseCase, String assignee)
            throws PersistanceException {
        Order order = getOrderByIdUseCase.handle(id);
        order = new OrderReady(order, assignee);
        return (OrderReady) order;
    }

    public OrderReady createOrderReady(Order order, String assignee) {
        OrderReady orderReady = new OrderReady(order, assignee);
        return orderReady;
    }

    private String[] formatAssigneeToArray(String assignee) {
        return assignee.split(",");
    }
}
