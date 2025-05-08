package com.ferrin.cookapp.dao;

import com.ferrin.cookapp.model.Recipe;
import com.ferrin.cookapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RecipeDAO {

    public void saveRecipe(Recipe recipe) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(recipe);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Recipe> getAllRecipes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Recipe", Recipe.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
