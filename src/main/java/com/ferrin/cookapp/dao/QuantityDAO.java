package com.ferrin.cookapp.dao;

import com.ferrin.cookapp.model.Quantity;
import com.ferrin.cookapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class QuantityDAO {

    public void saveQuantity(Quantity quantity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(quantity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Quantity> getQuantitiesForRecipe(Long recipeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Quantity WHERE recipe.id = :recipeId", Quantity.class)
                    .setParameter("recipeId", recipeId)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
