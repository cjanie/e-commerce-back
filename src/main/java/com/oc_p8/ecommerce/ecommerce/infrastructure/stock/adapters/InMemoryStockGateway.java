package com.oc_p8.ecommerce.ecommerce.infrastructure.stock.adapters;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.stock.gateways.StockGateway;

public class InMemoryStockGateway implements StockGateway {

    List<String> stock = new ArrayList<>();

    @Override
    public List<String> getStock() {
        return this.stock;
    }

    public void setStock(List<String> stock) {
        this.stock = stock;
    }
}