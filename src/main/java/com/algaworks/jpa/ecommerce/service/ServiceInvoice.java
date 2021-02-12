package com.algaworks.jpa.ecommerce.service;

import com.algaworks.jpa.ecommerce.model.Order;

public class ServiceInvoice {

    public void generate(Order order) {
        System.out.println("Generating invoice to the order " + order.getId() + ".");
    }
}
