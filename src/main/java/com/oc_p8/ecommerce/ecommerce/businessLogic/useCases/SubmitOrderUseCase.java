package com.oc_p8.ecommerce.ecommerce.businessLogic.useCases;

import com.oc_p8.ecommerce.ecommerce.businessLogic.entities.Order;
import com.oc_p8.ecommerce.ecommerce.businessLogic.enums.OrderState;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.ClientMissingInfoException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.EmptyCartException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.NotInStockException;
import com.oc_p8.ecommerce.ecommerce.businessLogic.exceptions.PaymentMissingAcceptanceException;

public class SubmitOrderUseCase {
    private CheckInStockUseCase checkInStockUseCase;

    public SubmitOrderUseCase(CheckInStockUseCase checkInStockUseCase) {
        this.checkInStockUseCase = checkInStockUseCase;
    }

    public Order handle(Order order) throws ClientMissingInfoException, EmptyCartException, NotInStockException, PaymentMissingAcceptanceException {
        this.edit(order);
        this.pay(order);
        this.send(order);
        return order;
    }

    private void edit(Order order) throws ClientMissingInfoException, EmptyCartException, NotInStockException {
        if(order.getClient() == null)
            throw new ClientMissingInfoException();
        if(order.getProducts().isEmpty())
            throw new EmptyCartException();
        if(!this.checkInStockUseCase.handle(order.getProducts()))
            throw new NotInStockException();
    }

    private void pay(Order order) throws PaymentMissingAcceptanceException {
        if(order.getPaymentStatus() == null) {
            throw new PaymentMissingAcceptanceException();
        }
    }

    private void send(Order order) {
        order.setState(OrderState.SEND);
    }

}
