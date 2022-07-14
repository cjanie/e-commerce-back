package com.oc_p8.ecommerce.ordercycle.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.GetOrdersReadyUseCase;
import com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.OrderReadyQueryGatewayImpl;

@RestController
@RequestMapping("/orders/ready")
@CrossOrigin(origins = "*")
public class OrderReadyController {

    @GetMapping
    public ResponseEntity<?> getOrdersReady() {
        return new ResponseEntity<List<Order>>(new GetOrdersReadyUseCase(new OrderReadyQueryGatewayImpl()).handle(),
                HttpStatus.OK);
    }
}
