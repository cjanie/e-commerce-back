package com.oc_p8.ecommerce.ordercycle.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.GetOrdersInPreparationUseCase;
import com.oc_p8.ecommerce.ordercycle.infrastructure.OrderInPreparationQueryGatewayImpl;

@RestController
@RequestMapping("/orders/preparation")
@CrossOrigin(origins = "*")
public class OrderInPreparationController {

    @GetMapping
    public List<Order> getOrdersInPreparation() {
        return new GetOrdersInPreparationUseCase(new OrderInPreparationQueryGatewayImpl()).handle();
    }

}
