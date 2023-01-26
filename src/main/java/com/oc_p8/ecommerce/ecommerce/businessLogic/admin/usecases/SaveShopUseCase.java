package com.oc_p8.ecommerce.ecommerce.businessLogic.admin.usecases;

import com.oc_p8.ecommerce.ecommerce.businessLogic.admin.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.admin.gateways.ShopCommandGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;


public class SaveShopUseCase {

    private ShopCommandGateway shopCommandGateway;

    public SaveShopUseCase(ShopCommandGateway shopCommandGateway) {
        this.shopCommandGateway = shopCommandGateway;
    }

    public Long handle(Shop shop) throws NullPayloadException {
        return this.shopCommandGateway.save(shop);
    }
    
}

