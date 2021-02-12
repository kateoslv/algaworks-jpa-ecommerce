package com.algaworks.jpa.ecommerce.gettingtoknowentitymanager;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Product;
import org.junit.Test;

import java.math.BigDecimal;

public class PersistenceContext extends EntityManagerTest {

    @Test
    public void usePersistenceContext() {

        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1);
        product.setPrice(new BigDecimal(100.0));

        Product cup = new Product();
        cup.setName("Cup");
        cup.setPrice(new BigDecimal(9.0));
        cup.setDescription("A random cup");

        entityManager.persist(cup);

        Product bottle = new Product();
        bottle.setName("Bottle");
        bottle.setPrice(new BigDecimal(10.0));
        bottle.setDescription("The new bottle of water");

        bottle = entityManager.merge(bottle);

        entityManager.flush();

        bottle.setDescription("Updating description");

        entityManager.getTransaction().commit();
    }
}
