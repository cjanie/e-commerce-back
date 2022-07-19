package com.oc_p8.ecommerce.orderdata.businesslogic.gateways;

import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Order;
import com.oc_p8.ecommerce.orderdata.businesslogic.exceptions.PersistanceException;

public interface OrderDataCommandGateway {
    Long saveOrder(Order order) throws PersistanceException;
}
