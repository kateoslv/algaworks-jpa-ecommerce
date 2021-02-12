package com.algaworks.jpa.ecommerce.relationships;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Client;
import com.algaworks.jpa.ecommerce.model.Order;
import com.algaworks.jpa.ecommerce.model.OrderItem;
import com.algaworks.jpa.ecommerce.model.OrderItemId;
import com.algaworks.jpa.ecommerce.model.Product;
import com.algaworks.jpa.ecommerce.model.StatusOrder;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ManyToOneRelationshipTest extends EntityManagerTest {

    @Test
    public void verifyRelationship() {

        Client client = entityManager.find(Client.class, 1);

        Order order = new Order();
        order.setCreationDate(LocalDateTime.now());
        order.setTotal(BigDecimal.TEN);
        order.setStatus(StatusOrder.WAITING);
        order.setClient(client);

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order verificationOrder = entityManager.find(Order.class, order.getId());
        Assert.assertNotNull(verificationOrder.getClient());
    }

    @Test
    public void verifyRelationshipOrderItem() {

        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 1);
        Product product = entityManager.find(Product.class, 1);

        Order order = new Order();
        order.setCreationDate(LocalDateTime.now());
        order.setTotal(BigDecimal.TEN);
        order.setStatus(StatusOrder.WAITING);
        order.setClient(client);

        entityManager.persist(order);

        entityManager.flush();

        OrderItem orderItem = new OrderItem();
        orderItem.setIdOrder(order.getId());
        orderItem.setIdProduct(product.getId());
        orderItem.setProductPrice(product.getPrice());
        orderItem.setAmount(1);
        orderItem.setOrder(order);
        orderItem.setProduct(product);

        entityManager.persist(orderItem);
        entityManager.getTransaction().commit();

        entityManager.clear();

        OrderItem verificationOrderItem = entityManager.find(
            OrderItem.class, new OrderItemId(order.getId(), product.getId()));

        Assert.assertNotNull(verificationOrderItem.getOrder());
        Assert.assertNotNull(verificationOrderItem.getProduct());
    }
}
