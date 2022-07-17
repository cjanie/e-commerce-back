package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

class OrderInPreparationFactory {

    private static OrderInPreparationFactory INSTANCE;

    private OrderInPreparationFactory() {

    }

    public static OrderInPreparationFactory getInstance() {
        if (OrderInPreparationFactory.INSTANCE == null) {
            OrderInPreparationFactory.INSTANCE = new OrderInPreparationFactory();
        }
        return OrderInPreparationFactory.INSTANCE;
    }

    public OrderInPreparation createOrderInPreparation(Long id, String assignee) {
        Order order = new OrderAtReceipt(id);
        order = new OrderInPreparation(order, assignee);
        return (OrderInPreparation) order;
    }
}
