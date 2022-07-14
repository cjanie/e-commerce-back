package com.oc_p8.ecommerce.ordercycle.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.GetOrdersInPreparationUseCase;
import com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.OrderInPreparationQueryGatewayImpl;

@RestController
@RequestMapping("/orders/preparation")
@CrossOrigin(origins = "*")
public class OrderInPreparationController {

    @GetMapping
    public ResponseEntity<?> getOrdersInPreparation() {
        return new ResponseEntity<List<Order>>(
                new GetOrdersInPreparationUseCase(new OrderInPreparationQueryGatewayImpl()).handle(), HttpStatus.OK);
    }

}
