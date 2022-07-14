package com.oc_p8.ecommerce;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Cart;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Client;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.Order;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderAtReceipt;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderInPreparation;
import com.oc_p8.ecommerce.ordercycle.businesslogic.entities.OrderReady;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);

		Order order = new OrderAtReceipt();
		order.setId(1L);
		Client client = new Client();
		client.setFirstName("Jojo");
		client.setLastName("Tronchon");
		order.setClient(client);
		Cart cart = new Cart();
		cart.getItems().addAll(Arrays.asList("item1", "item2"));
		order.setCart(cart);
		System.out.println(order.state() + " " + order.getHistoric());

		Order order2 = new OrderAtReceipt();
		order2.setId(2L);
		order2.setClient(client);
		order2.setCart(cart);
		order2 = new OrderInPreparation(order2, "Jojo");
		order2 = new OrderReady(order2, "Jojo");
		System.out.println(order2.state() + " " + order2.getHistoric());
	}

}
