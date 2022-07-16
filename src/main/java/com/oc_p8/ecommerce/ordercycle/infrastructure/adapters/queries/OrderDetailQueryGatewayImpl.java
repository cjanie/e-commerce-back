package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries;

import java.sql.SQLException;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderDetailQueryGateway;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.entities.OrderQueryDTO;

public class OrderDetailQueryGatewayImpl implements OrderDetailQueryGateway {

    private OrderQueryDAO dao;

    public OrderDetailQueryGatewayImpl(OrderQueryDAO dao) {
        this.dao = dao;
    }

    @Override
    public Order getOrderById(Long id) throws PersistanceException {
        try {
            OrderQueryDTO orderDTO = this.dao.findOrderById(id);

            if (orderDTO.getState() == OrderState.PREPARATION.ordinal()) { // TODO Pattern visitor
                return new OrderFactory().createOrder(
                        orderDTO.getId(),
                        OrderState.PREPARATION,
                        orderDTO.getAssignee());

            } else if (orderDTO.getState() == OrderState.READY.ordinal()) {
                return new OrderFactory().createOrder(
                        orderDTO.getId(),
                        OrderState.READY,
                        orderDTO.getAssignee());

            } else {
                return new OrderFactory().createOrder(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

}
