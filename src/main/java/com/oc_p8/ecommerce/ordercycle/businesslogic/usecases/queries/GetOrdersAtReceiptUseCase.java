package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries;

import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.queries.OrderAtReceiptQueryGateway;

public class GetOrdersAtReceiptUseCase {

    private OrderAtReceiptQueryGateway queryGateway;

    public GetOrdersAtReceiptUseCase(OrderAtReceiptQueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<Order> handle() throws PersistanceException {
        return this.queryGateway.getOrdersWhereStateIsAtReceipt();
    }
}
