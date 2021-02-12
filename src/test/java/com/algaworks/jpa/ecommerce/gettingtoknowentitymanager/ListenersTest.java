package com.algaworks.jpa.ecommerce.gettingtoknowentitymanager;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Client;
import com.algaworks.jpa.ecommerce.model.Order;
import com.algaworks.jpa.ecommerce.model.StatusOrder;
import org.junit.Assert;
import org.junit.Test;

public class ListenersTest extends EntityManagerTest {

    @Test
    public void callCallbacks() {

        Client client = entityManager.find(Client.class, 1);

        Order order = new Order();
        order.setClient(client);
        order.setStatus(StatusOrder.WAITING);

        entityManager.getTransaction().begin();

        entityManager.persist(order);
        entityManager.flush();

        order.setStatus(StatusOrder.PAID);

        entityManager.getTransaction().commit();
        entityManager.clear();

        Order verificationOrder = entityManager.find(Order.class, order.getId());
        //Assert.assertNotNull(verificationOrder.getCreationDate());
    }
}
