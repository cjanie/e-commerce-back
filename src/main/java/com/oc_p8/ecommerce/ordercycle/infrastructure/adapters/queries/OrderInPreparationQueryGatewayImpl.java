package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderFactory;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderInPreparationQueryGateway;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.entities.OrderQueryDTO;

public class OrderInPreparationQueryGatewayImpl implements OrderInPreparationQueryGateway {

    private OrderQueryDAO orderQueryDAO;

    public OrderInPreparationQueryGatewayImpl(OrderQueryDAO orderQueryDAO) {
        this.orderQueryDAO = orderQueryDAO;

    }

    @Override
    public List<Order> getOrdersWhereStateIsInPreparation() throws PersistanceException {

        try {
            List<Order> orders = new ArrayList<>();
            List<OrderQueryDTO> ordersDTOs = this.orderQueryDAO.findOrdersByState(OrderState.PREPARATION);
            if (!ordersDTOs.isEmpty()) {
                for (OrderQueryDTO orderDto : ordersDTOs) {
                    orders.add(this.createOrderFromOrderDTO(orderDto));
                }
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

    private Order createOrderFromOrderDTO(OrderQueryDTO orderDTO) {
        Order order = new OrderFactory().createOrder(orderDTO.getId(), OrderState.PREPARATION,
                orderDTO.getAssignees());
        return order;
    }

}
