package com.oc_p8.ecommerce.ecommerce.infrastructure.adapters.inmemory;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Item;
import com.oc_p8.ecommerce.ecommerce.businessLogic.gateways.StockGateway;

public class InMemoryStockGateway implements StockGateway {

    List<Item> stock = new ArrayList<>();

    @Override
    public List<Item> getStock() {
        return this.stock;
    }

    public void setStock(List<Item> stock) {
        this.stock = stock;
    }

    @Override
    public Boolean foundInStock(Long itemId) {
        // TODO Auto-generated method stub
        return null;
    }
}