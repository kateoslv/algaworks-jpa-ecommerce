package com.algaworks.jpa.ecommerce.relationships;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Order;
import org.junit.Test;

public class OptionalAttributeTest extends EntityManagerTest {

    @Test
    public void verifyBehaviour() {

        Order order = entityManager.find(Order.class, 1);
    }
}
