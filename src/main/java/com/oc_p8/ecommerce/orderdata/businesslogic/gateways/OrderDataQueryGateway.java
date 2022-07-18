package com.oc_p8.ecommerce.orderdata.businesslogic.gateways;

import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Order;
import com.oc_p8.ecommerce.orderdata.businesslogic.exceptions.PersistanceException;

public interface OrderDataQueryGateway {

    Order getOrderById(Long id) throws PersistanceException;
}
