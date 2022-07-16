package com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;

public interface OrderDetailQueryGateway {

    Order getOrderById(Long id) throws PersistanceException;

}
