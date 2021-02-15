package com.algaworks.jpa.ecommerce.advancedmapping;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Attribute;
import com.algaworks.jpa.ecommerce.model.Client;
import com.algaworks.jpa.ecommerce.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class ElementCollectionTest extends EntityManagerTest {

    @Test
    public void applyTags() {

        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1);
        product.setTags(Arrays.asList("ebook", "digital-book"));

        entityManager.getTransaction().commit();

        entityManager.clear();

        Product verificationProduct = entityManager.find(Product.class, product.getId());
        Assert.assertFalse(verificationProduct.getTags().isEmpty());
    }

    @Test
    public void applyAttributes() {

        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1);
        product.setAttributes(Arrays.asList(new Attribute("screen", "320x600")));

        entityManager.getTransaction().commit();

        entityManager.clear();

        Product verificationProduct = entityManager.find(Product.class, product.getId());
        Assert.assertFalse(verificationProduct.getAttributes().isEmpty());
    }

    @Test
    public void applyContact() {

        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 1);
        client.setContacts(Collections.singletonMap("email", "amelia@gmail.com"));

        entityManager.getTransaction().commit();

        entityManager.clear();

        Client verificationClient = entityManager.find(Client.class, client.getId());
        Assert.assertEquals(
                "amelia@gmail.com", verificationClient.getContacts().get("email"));
    }

}
