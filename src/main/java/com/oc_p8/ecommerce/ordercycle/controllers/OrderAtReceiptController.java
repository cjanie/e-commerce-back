package com.oc_p8.ecommerce.ordercycle.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.usecases.GetOrdersAtReceiptUseCase;
import com.oc_p8.ecommerce.ordercycle.infrastructure.OrderAtReceiptQueryGatewayImpl;

@RestController
@RequestMapping(value = "/orders/receipt")
@CrossOrigin(origins = "*")
public class OrderAtReceiptController {

    @GetMapping
    public List<Order> getOrdersAtReceipt() {
        return new GetOrdersAtReceiptUseCase(new OrderAtReceiptQueryGatewayImpl()).handle();

    }
}
