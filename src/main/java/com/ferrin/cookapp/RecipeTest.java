package com.ferrin.cookapp;

import com.ferrin.cookapp.model.Recipe;
import com.ferrin.cookapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RecipeTest {
    public static void main(String[] args) {
        // Open a session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Start a transaction
        Transaction transaction = session.beginTransaction();

        // Create a Recipe object
        Recipe recipe = new Recipe();
        recipe.setName("Tomato Pasta");
        recipe.setIngredients("Tomatoes, Pasta, Olive Oil, Garlic");
        recipe.setInstructions("1. Boil pasta. 2. Cook tomatoes. 3. Mix together.");

        // Save the recipe
        session.persist(recipe);

        // Commit the transaction
        transaction.commit();

        // Close the session
        session.close();

        System.out.println("Recipe saved successfully!");
    }
}
