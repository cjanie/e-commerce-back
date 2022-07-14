package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Cart;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Client;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.OrderAtReceiptQueryGateway;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.entities.OrderQueryDTO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.enums.OrderState;

public class OrderAtReceiptQueryGatewayImpl implements OrderAtReceiptQueryGateway {

    private OrderQueryDAO dao;

    public OrderAtReceiptQueryGatewayImpl(OrderQueryDAO dao) {
        this.dao = dao;
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
        Order order = new OrderAtReceipt();
        order.setId(orderDTO.getId());

        Client client = new Client();
        client.setFirstName(orderDTO.getClientFirstName());
        client.setLastName(orderDTO.getClientLastName());
        order.setClient(client);

        order.setCart(new Cart()); // TODO Cart

        return order;
    }

}