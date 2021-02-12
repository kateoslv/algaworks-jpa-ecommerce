package com.algaworks.jpa.ecommerce.listener;

import com.algaworks.jpa.ecommerce.model.Order;
import com.algaworks.jpa.ecommerce.service.ServiceInvoice;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class GenerateInvoiceListener {

    private ServiceInvoice serviceInvoice = new ServiceInvoice();

    @PrePersist
    @PreUpdate
    public void generate(Order order) {

        if(order.isPaid() && order.getInvoice() == null) {
            serviceInvoice.generate(order);
        }
    }
}
