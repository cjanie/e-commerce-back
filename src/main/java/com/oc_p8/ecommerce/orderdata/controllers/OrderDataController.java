package com.oc_p8.ecommerce.orderdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Cart;
import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Client;
import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Order;
import com.oc_p8.ecommerce.orderdata.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.orderdata.businesslogic.usecases.GetOrderByIdUseCase;
import com.oc_p8.ecommerce.orderdata.businesslogic.usecases.SaveOrderDataUseCase;
import com.oc_p8.ecommerce.orderdata.controllers.dto.OrderSentDTO;
import com.oc_p8.ecommerce.orderdata.infrastructure.adapters.OrderDataCommandGatewayImpl;
import com.oc_p8.ecommerce.orderdata.infrastructure.adapters.OrderDataQueryGatewayImpl;
import com.oc_p8.ecommerce.orderdata.infrastructure.repositories.OrderDataRepository;

@RestController
@RequestMapping("/order_data")
@CrossOrigin(origins = "*")
public class OrderDataController {

    @Autowired
    private OrderDataRepository repository;

    @GetMapping
    public ResponseEntity<?> getOrderById(@RequestParam Long id) {
        try {
            return new ResponseEntity<Order>(
                    new GetOrderByIdUseCase(new OrderDataQueryGatewayImpl(this.repository)).handle(id), HttpStatus.OK);
        } catch (PersistanceException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveOrderData(@RequestBody OrderSentDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());

        Client client = new Client();
        client.setFirstName(orderDTO.getClientFirstName());
        client.setLastName(orderDTO.getClientLastName());
        order.setClient(client);

        Cart cart = new Cart();
        cart.setItems(orderDTO.getItems());
        order.setCart(cart);

        try {
            return new ResponseEntity<Long>(
                    new SaveOrderDataUseCase(new OrderDataCommandGatewayImpl(this.repository)).handle(order),
                    HttpStatus.OK);
        } catch (PersistanceException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
        }
    }

}
