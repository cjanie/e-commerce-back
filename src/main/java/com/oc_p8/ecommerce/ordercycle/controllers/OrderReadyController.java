package com.oc_p8.ecommerce.ordercycle.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.queries.GetOrdersReadyUseCase;
import com.oc_p8.ecommerce.ordercycle.infrastructure.adapters.queries.OrderReadyQueryGatewayImpl;
import com.oc_p8.ecommerce.ordercycle.infrastructure.dao.OrderQueryDAO;

@RestController
@RequestMapping("/orders/ready")
@CrossOrigin(origins = "*")
public class OrderReadyController {

    @GetMapping
    public ResponseEntity<?> getOrdersReady() {
        try {
            return new ResponseEntity<List<Order>>(
                    new GetOrdersReadyUseCase(new OrderReadyQueryGatewayImpl(new OrderQueryDAO())).handle(),
                    HttpStatus.OK);
        } catch (PersistanceException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }
}
