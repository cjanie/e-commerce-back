package com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;

public interface OrderReadyCommandGateway {
    Long updateOrder(OrderReady orderReady) throws PersistanceException;
}
