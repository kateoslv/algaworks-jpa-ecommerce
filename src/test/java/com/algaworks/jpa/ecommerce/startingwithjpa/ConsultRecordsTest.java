package com.algaworks.jpa.ecommerce.startingwithjpa;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Product;
import org.junit.Assert;
import org.junit.Test;

public class ConsultRecordsTest extends EntityManagerTest {

    @Test
    public void findById() {

        Product product = entityManager.find(Product.class, 1);

        Assert.assertNotNull(product);
        Assert.assertEquals("Kindle", product.getName());
    }

    @Test
    public void updateReference() {

        Product product = entityManager.find(Product.class, 1);
        product.setName("Headphone");

        entityManager.refresh(product);

        Assert.assertEquals("Kindle", product.getName());
    }

}
