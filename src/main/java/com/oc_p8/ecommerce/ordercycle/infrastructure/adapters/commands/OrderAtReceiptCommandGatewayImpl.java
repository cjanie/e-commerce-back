package com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.commands;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderAtReceiptCommandGateway;
import com.oc_p8.ecommerce.ordercycle.infrastructure.entities.OrderCommandDTO;
import com.oc_p8.ecommerce.ordercycle.infrastructure.repositories.OrderCommandRepository;

public class OrderAtReceiptCommandGatewayImpl implements OrderAtReceiptCommandGateway {

    private OrderCommandRepository repository;

    public OrderAtReceiptCommandGatewayImpl(OrderCommandRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long save(OrderAtReceipt orderAtReceipt) {
        OrderCommandDTO orderDTO = new OrderCommandDTO();
        orderDTO.setId(orderAtReceipt.getId());
        orderDTO.setClientFirstName(orderAtReceipt.getClient().getFirstName());
        orderDTO.setClientLastName(orderAtReceipt.getClient().getLastName());
        // TODO Cart
        orderDTO.setState(orderAtReceipt.state());

        return this.repository.save(orderDTO).getId();

    }

}
