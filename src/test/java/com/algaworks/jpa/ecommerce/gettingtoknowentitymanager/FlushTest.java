package com.algaworks.jpa.ecommerce.gettingtoknowentitymanager;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Order;
import com.algaworks.jpa.ecommerce.model.StatusOrder;
import org.junit.Assert;
import org.junit.Test;

public class FlushTest extends EntityManagerTest {

    @Test(expected = Exception.class)
    public void callFlush() {

        try {
            entityManager.getTransaction().begin();

            Order order = entityManager.find(Order.class, 1);
            order.setStatus(StatusOrder.PAID);

            entityManager.flush();

            if (order.getPayment() == null) {
                throw new RuntimeException("Order still not paid.");
            }
            /*
            Order paidOrder = entityManager
                    .createQuery("SELECT o FROM Order o WHERE o.id = 1", Order.class)
                    .getSingleResult();

            Assert.assertEquals(order.getStatus(), paidOrder.getStatus());
            */
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
