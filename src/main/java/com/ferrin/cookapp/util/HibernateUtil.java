package com.ferrin.cookapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import io.github.cdimascio.dotenv.Dotenv;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Dotenv dotenv = Dotenv.configure().load();

            Configuration configuration = new Configuration().configure() // Loads hibernate.cfg.xml
                    .setProperty("hibernate.connection.username", dotenv.get("DB_USER"))
                    .setProperty("hibernate.connection.password", dotenv.get("DB_PASS"));;
            configuration.configure().addAnnotatedClass(com.ferrin.cookapp.model.Recipe.class);
            configuration.configure().addAnnotatedClass(com.ferrin.cookapp.model.Ingredient.class);
            configuration.configure().addAnnotatedClass(com.ferrin.cookapp.model.Quantity.class);
            configuration.configure().addAnnotatedClass(com.ferrin.cookapp.model.User.class);
            // looks for hibernate.cfg.xml in classpath

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
