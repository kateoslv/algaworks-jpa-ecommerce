package com.algaworks.jpa.ecommerce.relationships;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.CardPayment;
import com.algaworks.jpa.ecommerce.model.Invoice;
import com.algaworks.jpa.ecommerce.model.Order;
import com.algaworks.jpa.ecommerce.model.StatusPayment;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class OneToOneRelationshipTest extends EntityManagerTest {

    @Test
    public void verifyRelationship() {

        Order order = entityManager.find(Order.class, 1);

        CardPayment cardPayment = new CardPayment();
        cardPayment.setNumber("1234");
        cardPayment.setStatus(StatusPayment.PROCESSING);
        cardPayment.setOrder(order);

        entityManager.getTransaction().begin();
        entityManager.persist(cardPayment);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order verificationOrder = entityManager.find(Order.class, order.getId());
        Assert.assertNotNull(verificationOrder.getPayment());
    }

    @Test
    public void verifyInvoiceRelationship() {

        Order order = entityManager.find(Order.class, 1);

        Invoice invoice = new Invoice();
        invoice.setXml("TEST");
        invoice.setIssueDate(new Date());
        invoice.setOrder(order);

        entityManager.getTransaction().begin();
        entityManager.persist(invoice);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order verificationOrder = entityManager.find(Order.class, order.getId());
        Assert.assertNotNull(verificationOrder.getInvoice());
    }
}
