package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries;

import java.sql.SQLException;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderDetailQueryGateway;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.entities.OrderQueryDTO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.factories.VisitorOrderFactory;

public class OrderDetailQueryGatewayImpl implements OrderDetailQueryGateway {

    private OrderQueryDAO dao;

    private VisitorOrderFactory<Order> orderFactory;

    public OrderDetailQueryGatewayImpl(OrderQueryDAO dao) {
        this.dao = dao;
        this.orderFactory = new VisitorOrderFactory<>();
    }

    @Override
    public Order getOrderById(Long id) throws PersistanceException {
        try {
            OrderQueryDTO orderDTO = this.dao.findOrderById(id);

            if (orderDTO.getState() == OrderState.PREPARATION.ordinal()) { // TODO Pattern visitor
                return this.orderFactory.createOrder(
                        orderDTO.getId(),
                        OrderState.PREPARATION,
                        orderDTO.getAssignees());

            } else if (orderDTO.getState() == OrderState.READY.ordinal()) {
                return this.orderFactory.createOrder(
                        orderDTO.getId(),
                        OrderState.READY,
                        orderDTO.getAssignees());

            } else {
                return new OrderFactory().createOrder(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

}
