package com.ferrin.cookapp.dao;

import com.ferrin.cookapp.model.Ingredient;
import com.ferrin.cookapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class IngredientDAO {

    public void saveIngredient(Ingredient ingredient) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ingredient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Ingredient getIngredientByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Ingredient WHERE name = :name", Ingredient.class)
                    .setParameter("name", name)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Ingredient> getAllIngredients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Ingredient", Ingredient.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
