package com.oc_p8.ecommerce.ecommerce.controllers.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NullPayloadException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.entities.Shop;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.usecases.GetShopsUseCase;
import com.oc_p8.ecommerce.ecommerce.businessLogic.shop.usecases.SaveShopUseCase;
import com.oc_p8.ecommerce.ecommerce.infrastructure.shop.adapters.ShopCommandGatewayImpl;
import com.oc_p8.ecommerce.ecommerce.infrastructure.shop.adapters.ShopQueryGatewayImpl;
import com.oc_p8.ecommerce.ecommerce.infrastructure.shop.repositories.ShopRepository;

@RestController
@RequestMapping("/ecommerce/shops")
@CrossOrigin(origins = "*")
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    @GetMapping
    private ResponseEntity<?> getShops() {
        GetShopsUseCase getShopsUseCase = new GetShopsUseCase(new ShopQueryGatewayImpl(this.shopRepository));
        
        try {
            
            List<Shop> shops = getShopsUseCase.handle();
            return new ResponseEntity<List<Shop>>(shops, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getClass().getName() + e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }

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
