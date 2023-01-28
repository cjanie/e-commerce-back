package com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.adapters;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Item;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways.CatalogQueryGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto.CatalogDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.repositories.CatalogRepository;

public class CatalogQueryGatewayImpl implements CatalogQueryGateway {

    private CatalogRepository catalogRepository;

    public CatalogQueryGatewayImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Catalog getById(Long id) throws PersistanceException {

        try {
            CatalogDTO catalogDTO = this.catalogRepository.findById(id).get();

            return this.convertCatalogDtoToEntity(catalogDTO);

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

    

    private Catalog convertCatalogDtoToEntity(CatalogDTO catalogDTO) {
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

        return catalog;
    }
}
