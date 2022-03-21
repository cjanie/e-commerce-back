package com.oc_p8.ecommerce.adapters.secondary.gatewaysImpls;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.businessLogic.gateways.StockGateway;

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