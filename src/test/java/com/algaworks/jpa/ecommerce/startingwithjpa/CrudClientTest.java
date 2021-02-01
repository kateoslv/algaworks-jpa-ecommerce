package com.algaworks.jpa.ecommerce.startingwithjpa;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Client;
import org.junit.Assert;
import org.junit.Test;

public class CrudClientTest extends EntityManagerTest {

    @Test
    public void insertClient() {

        Client client = new Client();
        client.setId(3);
        client.setName("Anne");

        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client verificationClient = entityManager.find(Client.class, client.getId());
        Assert.assertNotNull(verificationClient);
    }

    @Test
    public void findClient() {

        Client client = entityManager.find(Client.class, 2);
        Assert.assertNotNull(client);
    }

    @Test
    public void updateClient() {

        Client client = new Client();
        client.setId(2);
        client.setName("John");

        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client verificationClient = entityManager.find(Client.class, 2);
        Assert.assertEquals("John", verificationClient.getName());
    }

    @Test
    public void deleteClient() {

        Client client = entityManager.find(Client.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(client);
        entityManager.getTransaction().commit();

        Client verificationClient = entityManager.find(Client.class, 2);
        Assert.assertNull(verificationClient);
    }

}
