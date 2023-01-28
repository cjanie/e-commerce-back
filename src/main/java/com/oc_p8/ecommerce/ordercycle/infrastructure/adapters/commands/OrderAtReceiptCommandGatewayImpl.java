package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.commands;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderAtReceiptCommandGateway;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dto.OrderCommandDTO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.repositories.OrderCommandRepository;

public class OrderAtReceiptCommandGatewayImpl implements OrderAtReceiptCommandGateway {

    private OrderCommandRepository repository;

    public OrderAtReceiptCommandGatewayImpl(OrderCommandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long save(OrderAtReceipt orderAtReceipt) throws PersistanceException {
        try {
            OrderCommandDTO orderDTO = new OrderCommandDTO();
            orderDTO.setId(orderAtReceipt.getId());
            orderDTO.setState(orderAtReceipt.state());
            orderDTO.setAssignees(null);

            return this.repository.save(orderDTO).getId();

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

}
