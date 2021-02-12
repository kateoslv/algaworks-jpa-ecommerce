package com.algaworks.jpa.ecommerce.relationships;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Category;
import com.algaworks.jpa.ecommerce.model.Client;
import org.junit.Assert;
import org.junit.Test;

public class AutoRelationshipTest extends EntityManagerTest {

    @Test
    public void verifyRelationship() {

        Category parentCategory = new Category();
        parentCategory.setName("Eletronics");

        Category subCategory = new Category();
        subCategory.setName("Smartphones");
        subCategory.setParentCategory(parentCategory);

        entityManager.getTransaction().begin();
        entityManager.persist(parentCategory);
        entityManager.persist(subCategory);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Category verificationCategory = entityManager.find(Category.class, subCategory.getId());
        Assert.assertNotNull(verificationCategory.getParentCategory());

        Category verificationParentCategory = entityManager.find(Category.class, parentCategory.getId());
        Assert.assertFalse(verificationParentCategory.getCategories().isEmpty());
    }

}
