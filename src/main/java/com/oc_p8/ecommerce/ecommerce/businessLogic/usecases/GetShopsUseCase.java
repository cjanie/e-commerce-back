package com.oc_p8.ecommerce.ecommerce.businessLogic.usecases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.gateways.ShopQueryGateway;

public class GetShopsUseCase {

    private ShopQueryGateway shopQueryGateway;

    public GetShopsUseCase(ShopQueryGateway shopQueryGateway) {
        this.shopQueryGateway = shopQueryGateway;
    }

    public List<Shop> handle() {
        return this.shopQueryGateway.findAll();
    }
    
}
