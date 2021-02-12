package com.algaworks.jpa.ecommerce.relationships;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Order;
import org.junit.Assert;
import org.junit.Test;

public class RemovingRelatedEntitiesTest extends EntityManagerTest {

    @Test
    public void removeRelatedEntities() {

        Order order = entityManager.find(Order.class, 1);

        Assert.assertFalse(order.getOrderItems().isEmpty());

        entityManager.getTransaction().begin();
        order.getOrderItems().forEach(i -> entityManager.remove(i));
        entityManager.remove(order);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Order verificationOrder = entityManager.find(Order.class, order.getId());
        Assert.assertNull(verificationOrder);
    }

}
