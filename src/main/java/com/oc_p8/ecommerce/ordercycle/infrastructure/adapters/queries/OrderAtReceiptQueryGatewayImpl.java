package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.enums.OrderState;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderAtReceiptQueryGateway;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dto.OrderQueryDTO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.factories.VisitorOrderFactory;

public class OrderAtReceiptQueryGatewayImpl implements OrderAtReceiptQueryGateway {

    private OrderQueryDAO dao;

    private VisitorOrderFactory<Order> orderFactory;

    public OrderAtReceiptQueryGatewayImpl(OrderQueryDAO dao) {
        this.dao = dao;
        this.orderFactory = new VisitorOrderFactory<>();
    }

    @Override
    public List<Order> getOrdersWhereStateIsAtReceipt() throws PersistanceException {
        List<Order> orders = new ArrayList<>();
        try {
            List<OrderQueryDTO> ordersDTOs = this.dao.findOrdersByState(OrderState.RECEIPT);
            if (!ordersDTOs.isEmpty()) {
                for (OrderQueryDTO orderDTO : ordersDTOs) {
                    orders.add(this.createOrderFromOrderDTO(orderDTO));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass().getName() + " " + e.getMessage());
        }
        return orders;
    }

    private Order createOrderFromOrderDTO(OrderQueryDTO orderDTO) {
        Order order = orderFactory.createOrder(orderDTO.getId(), OrderState.RECEIPT, orderDTO.getAssignees());
        return order;
    }

}