package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.commands;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderInPreparationCommandGateway;
import com.oc_p8.ecommerce.ordercycle.infrastructure.entities.OrderCommandDTO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.repositories.OrderCommandRepository;

public class OrderInPreparationCommandGatewayImpl implements OrderInPreparationCommandGateway {

    private OrderCommandRepository repository;

    public OrderInPreparationCommandGatewayImpl(OrderCommandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long updateOrder(OrderInPreparation order) throws PersistanceException {
        try {
            OrderCommandDTO orderDTO = new OrderCommandDTO();
            orderDTO.setId(order.getId());
            orderDTO.setState(order.state());
            orderDTO.setAssignee(order.assignee());
            return this.repository.save(orderDTO).getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

}
