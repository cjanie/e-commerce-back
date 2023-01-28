package com.oc_p8.ecommerce.ecommerce.infrastructure.adapters;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Item;
import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Stock;
import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.StockItem;
import com.oc_p8.ecommerce.ecommerce.businessLogic.gateways.ShopQueryGateway;
import com.oc_p8.ecommerce.ecommerce.infrastructure.dto.CatalogDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.dto.StockDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.dto.StockItemDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.repositories.ShopRepository;

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

            StockDTO stockDTO = dto.getStock();
            if(stockDTO != null) {
                Stock stock = new Stock();
                stock.setId(stockDTO.getId());

                if(!stockDTO.getItems().isEmpty()) {
                    List<StockItem> items = new ArrayList<>();
                    stockDTO.getItems().forEach(itemDTO -> {
                        StockItem item = new StockItem();
                        item.setId(itemDTO.getId());
                        item.setName(itemDTO.getName());
                        items.add(item);
                    });
                    stock.setItems(items);
                }
                shop.setStock(stock);
            }
            
            shops.add(shop);
        });

        return shops;
    }
    
}
