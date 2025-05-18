package com.ferrin.cookapp.service;

import com.ferrin.cookapp.model.User;
import com.ferrin.cookapp.dao.UserDAO;
import com.ferrin.cookapp.model.Recipe;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ferrin.cookapp.util.HibernateUtil;

import java.util.List;

public class FavouriteService {
    private final UserDAO userDAO = new UserDAO();
    private final AuthService authService = new AuthService();

    public void toggleFavorite(Recipe recipe) {
        User user = authService.getCurrentUser();
        if (user == null) throw new IllegalStateException("User not logged in");

        // Check current favorite status directly from database
        boolean isFavorite = isFavorite(recipe);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Re-fetch user to work with
            User managedUser = session.get(User.class, user.getId());

            if (isFavorite) {
                // Direct SQL approach to remove the relationship
                session.createNativeQuery(
                                "DELETE FROM user_favorites WHERE user_id = :userId AND recipe_id = :recipeId")
                        .setParameter("userId", user.getId())
                        .setParameter("recipeId", recipe.getId())
                        .executeUpdate();
            } else {
                // Use HQL to insert directly to avoid collection modifications
                session.createNativeQuery(
                                "INSERT INTO user_favorites (user_id, recipe_id) VALUES (:userId, :recipeId)")
                        .setParameter("userId", user.getId())
                        .setParameter("recipeId", recipe.getId())
                        .executeUpdate();
            }

            session.getTransaction().commit();

            // Refresh current user to get updated state
            authService.refreshCurrentUser(session.get(User.class, user.getId()));
        }
    }

    public boolean isFavorite(Recipe recipe) {
        User user = authService.getCurrentUser();
        if (user == null) return false;

        // Query within session to avoid LazyInitializationException
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            // Simple query to check if the user-recipe relationship exists in the join table
            Long count = session.createQuery(
                            "SELECT COUNT(u) FROM User u JOIN u.favorites f WHERE u.id = :userId AND f.id = :recipeId",
                            Long.class
                    )
                    .setParameter("userId", user.getId())
                    .setParameter("recipeId", recipe.getId())
                    .uniqueResult();

            return count > 0;
        }
    }

    public List<Recipe> getFavorites() {
        User user = authService.getCurrentUser();
        if (user == null) throw new IllegalStateException("User not logged in");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            // Query to get all favorite recipes for the current user
            return session.createQuery(
                            "SELECT r FROM User u JOIN u.favorites r WHERE u.id = :userId",
                            Recipe.class)
                    .setParameter("userId", user.getId())
                    .getResultList();
        }
    }
}