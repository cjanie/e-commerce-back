package com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.commands;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands.OrderAtReceiptCommandGateway;

public class SaveOrderAtReceiptUseCase {

    private OrderAtReceiptCommandGateway commandGateway;

    public SaveOrderAtReceiptUseCase(OrderAtReceiptCommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public Long handle(OrderAtReceipt orderAtReceipt) throws PersistanceException {
        return this.commandGateway.save(orderAtReceipt);
    }
}
