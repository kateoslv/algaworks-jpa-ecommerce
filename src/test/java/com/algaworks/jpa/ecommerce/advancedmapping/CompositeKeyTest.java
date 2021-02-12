package com.algaworks.jpa.ecommerce.advancedmapping;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Client;
import com.algaworks.jpa.ecommerce.model.Order;
import com.algaworks.jpa.ecommerce.model.OrderItem;
import com.algaworks.jpa.ecommerce.model.OrderItemId;
import com.algaworks.jpa.ecommerce.model.Product;
import com.algaworks.jpa.ecommerce.model.StatusOrder;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class CompositeKeyTest extends EntityManagerTest {

    @Test
    public void saveItem() {

        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 1);
        Product product = entityManager.find(Product.class, 1);

        Order order = new Order();
        order.setClient(client);
        order.setCreationDate(LocalDateTime.now());
        order.setStatus(StatusOrder.WAITING);
        order.setTotal(product.getPrice());

        entityManager.persist(order);

        entityManager.flush();

        OrderItem orderItem = new OrderItem();
        orderItem.setId(new OrderItemId(order.getId(), product.getId()));
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setProductPrice(product.getPrice());
        orderItem.setAmount(1);

        entityManager.persist(orderItem);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Order verificationOrder = entityManager.find(Order.class, order.getId());
        Assert.assertNotNull(verificationOrder);
        Assert.assertFalse(verificationOrder.getOrderItems().isEmpty());
    }

    @Test
    public void findItem() {

        OrderItem orderItem = entityManager.find(
                OrderItem.class, new OrderItemId(1, 1));

        Assert.assertNotNull(orderItem);
    }
}
