package com.oc_p8.ecommerce.adapters.primary.controllers;

import com.oc_p8.ecommerce.adapters.secondary.gatewaysImpls.InMemoryStockGateway;
import com.oc_p8.ecommerce.businessLogic.entities.Order;
import com.oc_p8.ecommerce.businessLogic.exceptions.ClientMissingInfoException;
import com.oc_p8.ecommerce.businessLogic.exceptions.EmptyCartException;
import com.oc_p8.ecommerce.businessLogic.exceptions.NotInStockException;
import com.oc_p8.ecommerce.businessLogic.exceptions.PaymentMissingAcceptanceException;
import com.oc_p8.ecommerce.businessLogic.useCases.CheckInStockUseCase;
import com.oc_p8.ecommerce.businessLogic.useCases.SubmitOrderUseCase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class SubmitOrderController {



    @PostMapping(value = "post")
    public ResponseEntity<?> order(@RequestBody Order order) {
        InMemoryStockGateway stockGateway = new InMemoryStockGateway();
        CheckInStockUseCase stockUseCase = new CheckInStockUseCase(stockGateway);
        SubmitOrderUseCase submitOrderUseCase = new SubmitOrderUseCase(stockUseCase);
        try {
            submitOrderUseCase.handle(order);
        } catch (ClientMissingInfoException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        } catch (EmptyCartException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        } catch (NotInStockException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_ACCEPTABLE);
        } catch (PaymentMissingAcceptanceException e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
    
}
