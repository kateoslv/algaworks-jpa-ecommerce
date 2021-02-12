package com.algaworks.jpa.ecommerce.gettingtoknowentitymanager;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Product;
import org.junit.Test;

public class CacheFirstLevel extends EntityManagerTest {

    @Test
    public void verifyCache() {

        Product product = entityManager.find(Product.class, 1);

        System.out.println(product.getName());
        System.out.println("--------------------");

        entityManager.clear();

        Product redeemedProduct = entityManager.find(Product.class, product.getId());
        System.out.println(redeemedProduct.getName());
    }
}
