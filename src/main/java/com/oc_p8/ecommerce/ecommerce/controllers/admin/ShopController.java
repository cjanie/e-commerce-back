package com.oc_p8.ecommerce.ecommerce.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ecommerce.businessLogic.admin.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.admin.usecases.SaveShopUseCase;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;
import com.oc_p8.ecommerce.ecommerce.infrastructure.admin.adapters.ShopCommandGatewayImpl;
import com.oc_p8.ecommerce.ecommerce.infrastructure.admin.repositories.ShopRepository;

@RestController
@RequestMapping("/ecommerce/shops")
@CrossOrigin(origins = "*")
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    @PostMapping
    public ResponseEntity<?> saveShop(@RequestBody Shop shop) {
        SaveShopUseCase saveShopUseCase = new SaveShopUseCase(new ShopCommandGatewayImpl(this.shopRepository));
            
        try {
            Long id = saveShopUseCase.handle(shop);
            return new ResponseEntity<Long>(id, HttpStatus.OK);

        } catch (NullPayloadException e) {
            return new ResponseEntity<String>(e.getClass().getName(), HttpStatus.PRECONDITION_FAILED);

        }
        
    }
    
}
