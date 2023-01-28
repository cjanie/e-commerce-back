package com.oc_p8.ecommerce.ecommerce.businessLogic.gateways;

import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Item;

public interface StockGateway {
    List<Item> getStock();

    Boolean foundInStock(Long itemId);
}
