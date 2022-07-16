package com.oc_p8.ecommerce.ordercycle.businesslogic.enums;

public interface OrderStateVisitor<T> {

    T visitReceipt();

    T visitPreparation();

    T visitReady();
}
