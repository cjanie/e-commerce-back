package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderReadyQueryGateway;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.entities.OrderQueryDTO;

public class OrderReadyQueryGatewayImpl implements OrderReadyQueryGateway {

    OrderQueryDAO dao;

    public OrderReadyQueryGatewayImpl(OrderQueryDAO dao) {
        this.dao = dao;

    }

    @Override
    public List<Order> getOrdersWhereStateIsReady() throws PersistanceException {

        try {
            List<Order> orders = new ArrayList<>();
            List<OrderQueryDTO> ordersDTOs = this.dao.findOrdersByState(OrderState.READY);
            if (!ordersDTOs.isEmpty()) {
                for (OrderQueryDTO orderDto : ordersDTOs) {
                    Order order = new OrderFactory().createOrder(
                            orderDto.getId(),
                            OrderState.READY,
                            orderDto.getAssignee());
                    // TODO with a second assignee
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
