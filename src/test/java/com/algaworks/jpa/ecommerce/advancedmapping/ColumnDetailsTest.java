package com.algaworks.jpa.ecommerce.advancedmapping;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ColumnDetailsTest extends EntityManagerTest {

    @Test
    public void avoidInsertionUpdateColumn() {

        Product product = new Product();
        product.setName("Headphone Sony");
        product.setDescription("The best noise cancelling.");
        product.setPrice(BigDecimal.ONE);
        product.setCreationDate(LocalDateTime.now());
        product.setLastUpdate(LocalDateTime.now());

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Product verificationProduct = entityManager.find(Product.class, product.getId());
        Assert.assertNotNull(verificationProduct.getCreationDate());
        Assert.assertNull(verificationProduct.getLastUpdate());
    }

    @Test
    public void avoidUpdateOnCreationColumn() {

        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1);
        product.setPrice(BigDecimal.TEN);
        product.setCreationDate(LocalDateTime.now());
        product.setLastUpdate(LocalDateTime.now());

        entityManager.getTransaction().commit();

        entityManager.clear();

        Product verificationProduct = entityManager.find(Product.class, product.getId());
        Assert.assertNotEquals(product.getCreationDate().truncatedTo(ChronoUnit.SECONDS),
                verificationProduct.getCreationDate().truncatedTo(ChronoUnit.SECONDS));

        Assert.assertEquals(product.getLastUpdate().truncatedTo(ChronoUnit.SECONDS),
                verificationProduct.getLastUpdate().truncatedTo(ChronoUnit.SECONDS));
    }

}
