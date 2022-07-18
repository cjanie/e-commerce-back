package com.oc_p8.ecommerce.orderdata.infrastructure.adapters;

import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Client;
import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Order;
import com.oc_p8.ecommerce.orderdata.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.orderdata.businesslogic.gateways.OrderDataQueryGateway;
import com.oc_p8.ecommerce.orderdata.infrastructure.dto.OrderDataDTO;
import com.oc_p8.ecommerce.orderdata.infrastructure.repositories.OrderDataRepository;

public class OrderDataQueryGatewayImpl implements OrderDataQueryGateway {

    private OrderDataRepository repository;

    public OrderDataQueryGatewayImpl(OrderDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order getOrderById(Long id) throws PersistanceException {
        try {

            OrderDataDTO dto = this.repository.findById(id).get();
            Order order = new Order();
            order.setId(id);

            Client client = new Client();
            client.setFirstName(dto.getClientFirstName());
            client.setLastName(dto.getClientLastName());
            order.setClient(client);

            // TODO Cart
            return order;

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

}
