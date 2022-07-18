package com.oc_p8.ecommerce.orderdata.infrastructure.adapters;

import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Order;
import com.oc_p8.ecommerce.orderdata.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.orderdata.businesslogic.gateways.OrderDataCommandGateway;
import com.oc_p8.ecommerce.orderdata.infrastructure.dto.OrderDataDTO;
import com.oc_p8.ecommerce.orderdata.infrastructure.repositories.OrderDataRepository;

public class OrderDataCommandGatewayImpl implements OrderDataCommandGateway {

    private OrderDataRepository repository;

    public OrderDataCommandGatewayImpl(OrderDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long saveOrder(Order order) throws PersistanceException {
        try {
            OrderDataDTO dataDTO = new OrderDataDTO();
            dataDTO.setId(order.getId());
            dataDTO.setClientFirstName(order.getClient().getFirstName());
            dataDTO.setClientLastName(order.getClient().getLastName());
            // TODO Cart
            return this.repository.save(dataDTO).getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }
}
