package com.oc_p8.ecommerce.ecommerce.businessLogic.order.usecases;

import com.oc_p8.ecommerce.ecommerce.businessLogic.order.entities.Order;
import com.oc_p8.ecommerce.ecommerce.businessLogic.order.exceptions.ClientMissingInfoException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.order.exceptions.EmptyCartException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.order.exceptions.PaymentMissingAcceptanceException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.stock.exceptions.NotInStockException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.stock.useCases.CheckInStockUseCase;

public class SubmitOrderUseCase {
    private CheckInStockUseCase checkInStockUseCase;

    public SubmitOrderUseCase(CheckInStockUseCase checkInStockUseCase) {
        this.checkInStockUseCase = checkInStockUseCase;
    }

    public Order handle(Order order) throws ClientMissingInfoException, EmptyCartException, NotInStockException,
            PaymentMissingAcceptanceException {
        this.edit(order);
        this.pay(order);
        this.send(order);
        return order;
    }

    private void edit(Order order) throws ClientMissingInfoException, EmptyCartException, NotInStockException {
        if (order.getClient() == null)
            throw new ClientMissingInfoException();
        if (order.getProducts().isEmpty())
            throw new EmptyCartException();
        if (!this.checkInStockUseCase.handle(order.getProducts()))
            throw new NotInStockException();
    }

    private void pay(Order order) throws PaymentMissingAcceptanceException {
        if (order.getPaymentStatus() == null) {
            throw new PaymentMissingAcceptanceException();
        }
    }

    private void send(Order order) {
        // TODO SEND
    }

}
