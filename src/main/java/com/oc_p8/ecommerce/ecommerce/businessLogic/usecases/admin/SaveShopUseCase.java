package com.oc_p8.ecommerce.ecommerce.businessLogic.usecases.admin;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.gateways.ShopCommandGateway;


public class SaveShopUseCase {

    private ShopCommandGateway shopCommandGateway;

    public SaveShopUseCase(ShopCommandGateway shopCommandGateway) {
        this.shopCommandGateway = shopCommandGateway;
    }

    public Long handle(Shop shop) throws NullPayloadException {
        return this.shopCommandGateway.save(shop);
    }
    
}

