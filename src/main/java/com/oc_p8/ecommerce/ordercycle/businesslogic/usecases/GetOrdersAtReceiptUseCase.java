package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases;

import java.util.List;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.OrderAtReceiptQueryGateway;

public class GetOrdersAtReceiptUseCase {

    private OrderAtReceiptQueryGateway queryGateway;

    public GetOrdersAtReceiptUseCase(OrderAtReceiptQueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public List<Order> handle() {
        return this.queryGateway.getOrdersWhereStateIsAtReceipt();
    }
}
