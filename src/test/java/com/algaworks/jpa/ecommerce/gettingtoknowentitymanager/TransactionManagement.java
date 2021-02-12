package com.algaworks.jpa.ecommerce.gettingtoknowentitymanager;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Order;
import com.algaworks.jpa.ecommerce.model.StatusOrder;
import org.junit.Test;

public class TransactionManagement extends EntityManagerTest {

    @Test
    public void openCloseAndCancelTransaction() {

        try {
            entityManager.getTransaction().begin();
            businessMethod();
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    private void businessMethod() {

        Order order = entityManager.find(Order.class, 1);
        order.setStatus(StatusOrder.PAID);

        if (order.getPayment() == null) {
            throw new RuntimeException("Order still not paid.");
        }
    }
}
