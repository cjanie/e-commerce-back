package com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries;

import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;

public interface OrderAtReceiptQueryGateway {
    List<Order> getOrdersWhereStateIsAtReceipt() throws PersistanceException;
}
