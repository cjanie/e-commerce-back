package com.oc_p8.ecommerce.ecommerce.businessLogic.shop.gateways;

import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.entities.Shop;

public interface ShopQueryGateway {

    List<Shop> findAll();
    
}
