package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderReadyQueryGateway;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.entities.OrderQueryDTO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.factories.VisitorOrderFactory;

public class OrderReadyQueryGatewayImpl implements OrderReadyQueryGateway {

    private OrderQueryDAO dao;

    private VisitorOrderFactory<Order> orderFactory;

    public OrderReadyQueryGatewayImpl(OrderQueryDAO dao) {
        this.dao = dao;
        this.orderFactory = new VisitorOrderFactory<>();

    }

    @Override
    public List<Order> getOrdersWhereStateIsReady() throws PersistanceException {

        try {
            List<Order> orders = new ArrayList<>();
            List<OrderQueryDTO> ordersDTOs = this.dao.findOrdersByState(OrderState.READY);
            if (!ordersDTOs.isEmpty()) {
                for (OrderQueryDTO orderDto : ordersDTOs) {
                    Order order = this.orderFactory.createOrder(
                            orderDto.getId(),
                            OrderState.READY,
                            orderDto.getAssignees());
                    orders.add(order);
                }
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

}
