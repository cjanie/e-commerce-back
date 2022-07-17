package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.commands;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderReadyCommandGateway;
import com.oc_p8.ecommerce.ordercycle.infrastructure.entities.OrderCommandDTO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.repositories.OrderCommandRepository;

public class OrderReadyCommandGatewayImpl implements OrderReadyCommandGateway {

    private OrderCommandRepository repository;

    public OrderReadyCommandGatewayImpl(OrderCommandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long updateOrder(OrderReady order) throws PersistanceException {
        try {
            OrderCommandDTO commandDTO = new OrderCommandDTO();
            commandDTO.setId(order.getId());
            commandDTO.setState(order.state());
            commandDTO.setAssignee(order.assignee());
            return this.repository.save(commandDTO).getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

}
