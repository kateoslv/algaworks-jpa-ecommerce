package com.algaworks.jpa.ecommerce.relationships;

import com.algaworks.jpa.ecommerce.EntityManagerTest;
import com.algaworks.jpa.ecommerce.model.Category;
import com.algaworks.jpa.ecommerce.model.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ManyToManyRelationshipTest extends EntityManagerTest {

    @Test
    public void verifyRelationship() {

        Product product = entityManager.find(Product.class, 1);
        Category category = entityManager.find(Category.class, 1);

        entityManager.getTransaction().begin();
        product.setCategories(Arrays.asList(category));
        entityManager.getTransaction().commit();

        entityManager.clear();

        Category verificationCategory = entityManager.find(Category.class, category.getId());
        Assert.assertFalse(verificationCategory.getProducts().isEmpty());
    }
}
