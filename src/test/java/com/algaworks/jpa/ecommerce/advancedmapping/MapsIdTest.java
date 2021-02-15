package com.algaworks.jpa.ecommerce.advancedmapping;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Client;
import com.algaworks.jpa.ecommerce.model.Invoice;
import com.algaworks.jpa.ecommerce.model.Order;
import com.algaworks.jpa.ecommerce.model.OrderItem;
import com.algaworks.jpa.ecommerce.model.OrderItemId;
import com.algaworks.jpa.ecommerce.model.Product;
import com.algaworks.jpa.ecommerce.model.StatusOrder;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class MapsIdTest extends EntityManagerTest {

    @Test
    public void insertPayment() {

        Order order = entityManager.find(Order.class, 1);

        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setIssueDate(new Date());
        invoice.setXml("<xml/>");

        entityManager.getTransaction().begin();
        entityManager.persist(invoice);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Invoice verificationInvoice = entityManager.find(Invoice.class, invoice.getId());
        Assert.assertNotNull(verificationInvoice);
        Assert.assertEquals(order.getId(), verificationInvoice.getId());
    }

    @Test
    public void insertOrderItem() {

        Client client = entityManager.find(Client.class, 1);
        Product product = entityManager.find(Product.class, 1);

        Order order = new Order();
        order.setClient(client);
        order.setCreationDate(LocalDateTime.now());
        order.setStatus(StatusOrder.WAITING);
        order.setTotal(product.getPrice());

        OrderItem orderItem = new OrderItem();
        orderItem.setId(new OrderItemId());
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setProductPrice(product.getPrice());
        orderItem.setAmount(1);

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.persist(orderItem);
        entityManager.getTransaction().commit();

        entityManager.clear();

        OrderItem verificationOrderItem = entityManager.find(
                OrderItem.class, new OrderItemId(order.getId(), product.getId()));
        Assert.assertNotNull(verificationOrderItem);
    }

}
