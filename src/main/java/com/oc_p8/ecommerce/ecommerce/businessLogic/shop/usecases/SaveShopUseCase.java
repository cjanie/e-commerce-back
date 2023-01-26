package com.oc_p8.ecommerce.ecommerce.businessLogic.shop.usecases;

import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.gateways.ShopCommandGateway;


public class SaveShopUseCase {

    private ShopCommandGateway shopCommandGateway;

    public SaveShopUseCase(ShopCommandGateway shopCommandGateway) {
        this.shopCommandGateway = shopCommandGateway;
    }

    public Long handle(Shop shop) throws NullPayloadException {
        return this.shopCommandGateway.save(shop);
    }
    
}

