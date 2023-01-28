package com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.adapters;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Item;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.gateways.ItemCommandGateway;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto.CatalogDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.dto.CatalogItemDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.repositories.CatalogItemRepository;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;

public class ItemCommandGatewayImpl implements ItemCommandGateway {

    private CatalogItemRepository repository;

    public ItemCommandGatewayImpl(CatalogItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long save(Long catalogId, Item item) throws PersistanceException {

        try {

            CatalogDTO catalogDTO = new CatalogDTO();
            catalogDTO.setId(catalogId);
            CatalogItemDTO itemDTO = new CatalogItemDTO();
            itemDTO.setId(item.getId());
            itemDTO.setName(item.getName());
            itemDTO.setCatalog(catalogDTO);

            return repository.save(itemDTO).getId();

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

}
