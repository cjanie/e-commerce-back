package com.oc_p8.ecommerce;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import com.oc_p8.ecommerce.ecommerce.adapters.secondary.gatewaysImpls.InMemoryStockGateway;
import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Client;
import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Order;
import com.oc_p8.ecommerce.ecommerce.businessLogic.enums.OrderState;
import com.oc_p8.ecommerce.ecommerce.businessLogic.enums.PaymentStatus;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.ClientMissingInfoException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.EmptyCartException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NotInStockException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PaymentMissingAcceptanceException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.useCases.CheckInStockUseCase;
import com.oc_p8.ecommerce.ecommerce.businessLogic.useCases.SubmitOrderUseCase;

import org.junit.jupiter.api.Test;

public class SubmitOrderUseCaseTests {


    @Test
    public void returnsClientMissingInfoError() {
        InMemoryStockGateway stockGateway = new InMemoryStockGateway();
        CheckInStockUseCase checkInStockUseCase = new CheckInStockUseCase(stockGateway);
        SubmitOrderUseCase submitOrderUseCase = new SubmitOrderUseCase(checkInStockUseCase);
        Order order = new Order();
        assertThrows(ClientMissingInfoException.class, () -> {
            submitOrderUseCase.handle(order);
        });
    }

    @Test
    public void returnsEmptyCartError() throws NotInStockException {
        InMemoryStockGateway stockGateway = new InMemoryStockGateway();
        CheckInStockUseCase checkInStockUseCase = new CheckInStockUseCase(stockGateway);
        SubmitOrderUseCase submitOrderUseCase = new SubmitOrderUseCase(checkInStockUseCase);
        Order order = new Order();
        order.setClient(new Client());
        assertThrows(EmptyCartException.class, () -> {
            submitOrderUseCase.handle(order);
        });
    }

    @Test
    public void returnsNotInStockWhenProductsAreNotInStock() {
        InMemoryStockGateway stockGateway = new InMemoryStockGateway();
        CheckInStockUseCase checkInStockUseCase = new CheckInStockUseCase(stockGateway);
        SubmitOrderUseCase submitOrderUseCase = new SubmitOrderUseCase(checkInStockUseCase);
        
        Order order = new Order();
        order.setClient(new Client());
        order.setProducts(Arrays.asList("ananas"));
        assertThrows(NotInStockException.class, () -> {
            submitOrderUseCase.handle(order);
        });
    }

    @Test
    public void returnsMissingPaymentAcceptanceError() {
        InMemoryStockGateway stockGateway = new InMemoryStockGateway();
        stockGateway.setStock(Arrays.asList("tomates"));
        CheckInStockUseCase checkInStockUseCase = new CheckInStockUseCase(stockGateway);
        SubmitOrderUseCase submitOrderUseCase = new SubmitOrderUseCase(checkInStockUseCase);
        Order order = new Order();
        order.setClient(new Client());
        order.setProducts(Arrays.asList("tomates"));
        assertThrows(PaymentMissingAcceptanceException.class, () -> {
            submitOrderUseCase.handle(order);
        });
    }

    @Test
    public void recordsOrderStateSend() throws ClientMissingInfoException, EmptyCartException, NotInStockException, PaymentMissingAcceptanceException {
        InMemoryStockGateway stockGateway = new InMemoryStockGateway();
        stockGateway.setStock(Arrays.asList("tomates"));
        CheckInStockUseCase checkInStockUseCase = new CheckInStockUseCase(stockGateway);
        SubmitOrderUseCase submitOrderUseCase = new SubmitOrderUseCase(checkInStockUseCase);

        Order order = new Order();
        order.setClient(new Client());
        order.setProducts(Arrays.asList("tomates"));
        order.setPaymentStatus(PaymentStatus.TO_PAY_AT_DELIVERY);
        assert(submitOrderUseCase.handle(order).getState().equals(OrderState.SEND));
    }

}