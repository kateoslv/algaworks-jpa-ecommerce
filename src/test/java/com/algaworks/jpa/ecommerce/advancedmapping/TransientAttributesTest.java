package com.algaworks.jpa.ecommerce.advancedmapping;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Client;
import org.junit.Assert;
import org.junit.Test;

public class TransientAttributesTest extends EntityManagerTest {

    @Test
    public void validateFirstName() {

        Client client = entityManager.find(Client.class, 1);

        Assert.assertEquals("Amelia", client.getFirstName());
    }

}
