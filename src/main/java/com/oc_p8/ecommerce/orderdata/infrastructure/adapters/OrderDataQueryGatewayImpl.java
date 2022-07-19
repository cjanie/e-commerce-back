package com.oc_p8.ecommerce.orderdata.infrastructure.adapters;

import java.util.ArrayList;
import java.util.List;

import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Cart;
import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Client;
import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Item;
import com.oc_p8.ecommerce.orderdata.businesslogic.entities.Order;
import com.oc_p8.ecommerce.orderdata.businesslogic.exceptions.PersistanceException;
import com.oc_p8.ecommerce.orderdata.businesslogic.gateways.OrderDataQueryGateway;
import com.oc_p8.ecommerce.orderdata.infrastructure.dto.CartItemDTO;
import com.oc_p8.ecommerce.orderdata.infrastructure.dto.OrderDataDTO;
import com.oc_p8.ecommerce.orderdata.infrastructure.repositories.OrderDataRepository;

public class OrderDataQueryGatewayImpl implements OrderDataQueryGateway {

    private OrderDataRepository repository;

    public OrderDataQueryGatewayImpl(OrderDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order getOrderById(Long id) throws PersistanceException {
        try {

            OrderDataDTO dto = this.repository.findById(id).get();
            Order order = new Order();
            order.setId(id);

            Client client = new Client();
            client.setFirstName(dto.getClientFirstName());
            client.setLastName(dto.getClientLastName());
            order.setClient(client);

            Cart cart = new Cart();
            List<Item> items = new ArrayList<>();
            List<CartItemDTO> itemDTOs = dto.getCartItems();
            for (CartItemDTO itemDTO : itemDTOs) {
                Item item = new Item();
                item.setId(itemDTO.getItemId());
                item.setName(itemDTO.getName());
                item.setPrice(itemDTO.getPrice());
                items.add(item);
            }
            cart.setItems(items);
            order.setCart(cart);
            return order;

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistanceException(e.getClass() + " " + e.getMessage());
        }

    }

}
