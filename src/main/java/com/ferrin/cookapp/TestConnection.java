package com.ferrin.cookapp;

import com.ferrin.cookapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestConnection {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        try (Session session = factory.openSession()) {
            System.out.println("Successfully connected to the database using Hibernate!");
        } catch (Exception e) {
            System.err.println("Failed to connect to the database:");
            e.printStackTrace();
        }
    }
}
