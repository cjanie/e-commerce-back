package com.oc_p8.ecommerce.ecommerce.infrastructure.shop.adapters;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.gateways.ShopQueryGateway;
import com.oc_p8.ecommerce.ecommerce.infrastructure.shop.repositories.ShopRepository;

public class ShopQueryGatewayImpl implements ShopQueryGateway {

    private ShopRepository shopRepository;

    public ShopQueryGatewayImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public List<Shop> findAll() {
        List<Shop> shops = new ArrayList<>();

        this.shopRepository.findAll().forEach(dto -> {
            Shop shop = new Shop();
            shop.setId(dto.getId());
            shop.setName(dto.getName());

            shops.add(shop);
        });

        return shops;
    }
    
}
