package com.oc_p8.ecommerce.ecommerce.businessLogic.gateways;

import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Shop;

public interface ShopQueryGateway {

    List<Shop> findAll();
    
}