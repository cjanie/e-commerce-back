package com.oc_p8.ecommerce.ecommerce.businessLogic.stock.useCases;

import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.stock.gateways.StockGateway;

public class CheckInStockUseCase {
    private StockGateway stockGateway;

    public CheckInStockUseCase(StockGateway stockGateway) {
        this.stockGateway = stockGateway;
    }

    public boolean handle(List<String> products) {
        return this.checkInStock(products);
    }

    private boolean checkInStock(List<String> products) {
        List<String> stock = this.stockGateway.getStock();
        for (String product : products) {
            if (stock.contains(product)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
