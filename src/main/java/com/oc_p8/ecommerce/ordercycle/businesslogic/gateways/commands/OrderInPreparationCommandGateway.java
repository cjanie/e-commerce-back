package com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;

public interface OrderInPreparationCommandGateway {
    Long updateOrder(OrderInPreparation order) throws PersistanceException;
}
