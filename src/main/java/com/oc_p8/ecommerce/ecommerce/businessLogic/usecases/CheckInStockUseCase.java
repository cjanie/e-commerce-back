package com.oc_p8.ecommerce.ecommerce.businessLogic.usecases;

import com.oc_p8.ecommerce.ecommerce.businessLogic.gateways.StockGateway;

public class CheckInStockUseCase {
    private StockGateway stockGateway;

    public CheckInStockUseCase(StockGateway stockGateway) {
        this.stockGateway = stockGateway;
    }

    public Boolean handle(Long itemId) {
        return this.stockGateway.foundInStock(itemId);
    }
    
}
