package com.oc_p8.ecommerce.ordercycle.businesslogic.gateways.commands;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;

public interface OrderAtReceiptCommandGateway {

    Long save(OrderAtReceipt orderAtReceipt);

}