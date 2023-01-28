package com.oc_p8.ecommerce.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.usecases.GetCatalogByIdUseCase;
import com.oc_p8.ecommerce.ecommerce.infrastructure.adapters.CatalogQueryGatewayImpl;
import com.oc_p8.ecommerce.ecommerce.infrastructure.repositories.CatalogRepository;

@RestController
@RequestMapping("/ecommerce/catalogs")
public class CatalogController {

    @Autowired
    private CatalogRepository catalogRepository;

    @GetMapping
    public ResponseEntity<?> getCatalogById(@RequestParam Long id) {
        try {
            return new ResponseEntity<Catalog>(
                    new GetCatalogByIdUseCase(new CatalogQueryGatewayImpl(catalogRepository)).handle(id),
                    HttpStatus.OK);
        } catch (PersistanceException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }

}
