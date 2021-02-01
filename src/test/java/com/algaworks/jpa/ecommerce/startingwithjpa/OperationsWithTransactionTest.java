package com.algaworks.jpa.ecommerce.startingwithjpa;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperationsWithTransactionTest extends EntityManagerTest {

    @Test
    public void preventDatabaseOperation() {

        Product product = entityManager.find(Product.class, 1);

        entityManager.detach(product);

        entityManager.getTransaction().begin();
        product.setName("Kindle Paperwhite");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Product verificationProduct = entityManager.find(Product.class, product.getId());
        Assert.assertEquals("Kindle", verificationProduct.getName());
    }

    @Test
    public void insertObject() {

        Product product = new Product();
        product.setId(2);
        product.setName("Headphone Sony");
        product.setDescription("The best noise canceling ever.");
        product.setPrice(new BigDecimal(380.00));

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Test
    public void insertObjectWithMerge() {

        Product product = new Product();
        product.setId(4);
        product.setName("Tv LG");
        product.setDescription("The best tv ever.");
        product.setPrice(new BigDecimal(200.00));

        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Product verificationProduct = entityManager.find(Product.class, product.getId());
        Assert.assertNotNull(verificationProduct);
    }

    @Test
    public void showDifferenceBetweenPersistAndMerge() {

        Product productPersist = new Product();
        productPersist.setId(5);
        productPersist.setName("Iphone");
        productPersist.setDescription("The best iphone ever.");
        productPersist.setPrice(new BigDecimal(400.00));

        entityManager.getTransaction().begin();
        entityManager.persist(productPersist);
        productPersist.setName("Iphone X");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Product verificationPersistProduct = entityManager.find(Product.class, productPersist.getId());
        Assert.assertNotNull(verificationPersistProduct);


        Product productMerge = new Product();
        productMerge.setId(5);
        productMerge.setName("Macbook Pro");
        productMerge.setDescription("The best notebook ever.");
        productMerge.setPrice(new BigDecimal(500.00));

        entityManager.getTransaction().begin();
        productMerge = entityManager.merge(productMerge);
        productMerge.setName("Macbook Pro 2021");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Product verificationMergeProduct = entityManager.find(Product.class, productMerge.getId());
        Assert.assertNotNull(verificationMergeProduct);
        Assert.assertEquals("Macbook Pro 2021", productMerge.getName());
    }

    @Test
    public void updateObject() {

        Product product = new Product();
        product.setId(1);
        product.setName("Kindle");
        product.setDescription("The best kindle ever.");
        product.setPrice(new BigDecimal(199));

        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Product verificationProduct = entityManager.find(Product.class, product.getId());
        Assert.assertNotNull(verificationProduct);
        Assert.assertEquals("Kindle", product.getName());
    }

    @Test
    public void updateObjectManaged() {

        Product product = entityManager.find(Product.class, 1);

        entityManager.getTransaction().begin();
        product.setName("Kindle Paperwhite");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Product verificationProduct = entityManager.find(Product.class, product.getId());
        Assert.assertEquals("Kindle Paperwhite", verificationProduct.getName());
    }

    @Test
    public void removeObject() {

         Product product = entityManager.find(Product.class, 3);

         entityManager.getTransaction().begin();
         entityManager.remove(product);
         entityManager.getTransaction().commit();

         Product verificationProduct = entityManager.find(Product.class, 3);
         Assert.assertNull(verificationProduct);
    }

}
