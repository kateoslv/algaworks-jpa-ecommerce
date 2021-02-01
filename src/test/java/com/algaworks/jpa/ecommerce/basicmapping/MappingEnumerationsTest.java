package com.algaworks.jpa.ecommerce.basicmapping;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Client;
import com.algaworks.jpa.ecommerce.model.Gender;
import org.junit.Assert;
import org.junit.Test;

public class MappingEnumerationsTest extends EntityManagerTest {

    @Test
    public void testEnum() {

        Client client = new Client();

        client.setId(3);
        client.setName("Pietro");
        client.setGender(Gender.MALE);

        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Client verificationClient = entityManager.find(Client.class, client.getId());
        Assert.assertNotNull(verificationClient);

    }

}
