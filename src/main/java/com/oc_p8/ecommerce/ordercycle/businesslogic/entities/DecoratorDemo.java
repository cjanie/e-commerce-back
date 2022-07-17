package com.oc_p8.ecommerce.ordercycle.businesslogic.entities;

public class DecoratorDemo {

    public void run() {
        // Create an instance of Order
        Order order = new OrderAtReceipt(1L);
        this.printOrder(order);

        // Pass Order Into Preparation by assignee
        order = new OrderInPreparation(order, "Valérien");
        this.printOrder(order);

        // Pass Order To Ready by assignee
        order = new OrderReady(order, "Valérien");
        this.printOrder(order);
    }

    private void printOrder(Order order) {
        System.out.println("Order id " + order.id + " Historic: " + order.getHistoric());
    }
}
