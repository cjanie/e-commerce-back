package com.oc_p8.ecommerce.orderdata.businesslogic.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Cart;
import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Client;
import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Order;
import com.oc_p8.ecommerce.orderdata.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.orderdata.businesslogic.gateways.OrderDataQueryGateway;

class InMemoryOrderDataQueryGatewayImpl implements OrderDataQueryGateway {

    @Override
    public Order getOrderById(Long id) {
        Order order = new Order();
        order.setId(id);

        Client client = new Client();
        client.setFirstName("Janie");
        client.setLastName("Lol");
        order.setClient(client);

        Cart cart = new Cart();
        List<Long> items = new ArrayList<>();
        items.add(1L);
        items.add(2L);
        cart.setItems(items);
        order.setCart(cart);

        return order;
    }

}

public class GetOrderByIdUseCaseTests {

    @Test
    public void returnsOrderWhenFound() throws PersistanceException {
        InMemoryOrderDataQueryGatewayImpl queryGateway = new InMemoryOrderDataQueryGatewayImpl();
        assertEquals(1L, new GetOrderByIdUseCase(queryGateway).handle(1L).getId());
    }

    @Test
    public void orderHasClient() throws PersistanceException {
        InMemoryOrderDataQueryGatewayImpl queryGateway = new InMemoryOrderDataQueryGatewayImpl();
        assertEquals("Janie", new GetOrderByIdUseCase(queryGateway).handle(2L).getClient().getFirstName());
    }

    @Test
    public void orderHasCart() throws PersistanceException {
        InMemoryOrderDataQueryGatewayImpl queryGateway = new InMemoryOrderDataQueryGatewayImpl();

        assertEquals(2, new GetOrderByIdUseCase(queryGateway).handle(2L).getCart().getItems().size());
    }

}
