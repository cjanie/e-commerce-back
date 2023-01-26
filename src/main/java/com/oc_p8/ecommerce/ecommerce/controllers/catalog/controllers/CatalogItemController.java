package com.oc_p8.ecommerce.ecommerce.controllers.catalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Item;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.usecases.Admin.SaveItemUseCase;
import com.oc_p8.ecommerce.ecommerce.controllers.catalog.dto.CatalogItemDTO;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.adapters.ItemCommandGatewayImpl;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.repositories.CatalogItemRepository;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;

@RestController
@RequestMapping("/catalogs_items")
public class CatalogItemController {

    @Autowired
    private CatalogItemRepository repository;

    @GetMapping
    public ResponseEntity<?> saveCatalogItem(@RequestBody CatalogItemDTO itemDTO) {
        try {
            Item item = new Item();
            item.setId(itemDTO.getId());
            item.setName(itemDTO.getName());
            return new ResponseEntity<Long>(
                    new SaveItemUseCase(new ItemCommandGatewayImpl(repository)).handle(itemDTO.getCatalogId(), item),
                    HttpStatus.OK);
        } catch (PersistanceException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
