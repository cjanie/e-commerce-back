package com.oc_p8.ecommerce.ecommerce.infrastructure.shop.adapters;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Item;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.gateways.ShopQueryGateway;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto.CatalogDTO;
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

            CatalogDTO catalogDTO = dto.getCatalog();
            if(catalogDTO != null) {
                Catalog catalog = new Catalog();
                catalog.setId(catalogDTO.getId());

                if(!catalogDTO.getItems().isEmpty()) {
                    List<Item> items = new ArrayList<>();
                    catalogDTO.getItems().forEach(itemDTO -> {
                        Item item = new Item();
                        item.setId(itemDTO.getId());
                        item.setName(itemDTO.getName());
                        items.add(item);
                    });
                    catalog.setItems(items);
                }
                shop.setCatalog(catalog);

                
            }

            shops.add(shop);
        });

        return shops;
    }
    
}
