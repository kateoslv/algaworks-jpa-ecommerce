package com.algaworks.jpa.ecommerce.gettingtoknowentitymanager;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Category;
import org.junit.Test;

public class StatesAndLifeCicle extends EntityManagerTest {

    @Test
    public void verifyStates() {

        Category category = new Category();

        Category managedCategory = entityManager.find(Category.class, 1);

        entityManager.remove(managedCategory);

        entityManager.persist(managedCategory);


    }

}
