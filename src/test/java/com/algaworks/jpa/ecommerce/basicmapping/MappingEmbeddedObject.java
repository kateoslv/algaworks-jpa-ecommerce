package com.algaworks.jpa.ecommerce.basicmapping;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Order;
import com.algaworks.jpa.ecommerce.model.OrderDeliveryAddress;
import com.algaworks.jpa.ecommerce.model.StatusOrder;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MappingEmbeddedObject extends EntityManagerTest {

    @Test
    public void analyzeEmbeddedObjectMapping() {

        OrderDeliveryAddress address = new OrderDeliveryAddress();
        address.setPostalCode("0000-000");
        address.setNeighborhood("Av. Aliados");
        address.setNumber(45);
        address.setCity("Aliados");
        address.setState("Porto");

        Order order = new Order();
        order.setId(1);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(StatusOrder.WAITING);
        order.setTotal(new BigDecimal(9.50));
        order.setDeliveryAddress(address);

        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order verificationOrder = entityManager.find(Order.class, order.getId());
        Assert.assertNotNull(verificationOrder);
        Assert.assertNotNull(verificationOrder.getDeliveryAddress());
        Assert.assertNotNull(verificationOrder.getDeliveryAddress().getPostalCode());
    }

}
