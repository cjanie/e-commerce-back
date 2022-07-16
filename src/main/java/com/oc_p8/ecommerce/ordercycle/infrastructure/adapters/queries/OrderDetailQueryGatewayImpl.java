package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries;

import java.sql.SQLException;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparationFactory;
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

            if (orderDTO.getState() == 1) { // TODO Pattern visitor
                return OrderInPreparationFactory.getInstance().createOrderInPreparation(orderDTO.getId(),
                        orderDTO.getAssignee());
            } else {
                Order order = new OrderAtReceipt();
                order.setId(orderDTO.getId());
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

}
