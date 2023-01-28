package com.oc_p8.ecommerce.ecommerce.controllers.catalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.entities.Catalog;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.usecases.Admin.SaveCatalogUseCase;
import com.oc_p8.ecommerce.ecommerce.businessLogic.catalog.usecases.User.GetCatalogByIdUseCase;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.adapters.CatalogCommandGatewayImpl;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.adapters.CatalogQueryGatewayImpl;
import com.oc_p8.ecommerce.ecommerce.infrastructure.catalog.repositories.CatalogRepository;

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

    @PostMapping
    public ResponseEntity<?> saveCatalog(@RequestBody Catalog catalog) {
        try {
            return new ResponseEntity<Long>(
                new SaveCatalogUseCase(new CatalogCommandGatewayImpl(catalogRepository)).handle(catalog),
                HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>(e.getClass().getName() + " " + e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }

}
