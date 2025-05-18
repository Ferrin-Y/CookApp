package com.ferrin.cookapp.util;

import com.ferrin.cookapp.model.User;
import com.ferrin.cookapp.dao.UserDAO;

public class DataInitializer {
    public static void initializeAdmin() {
        UserDAO userDAO = new UserDAO();
        if (userDAO.findByUsername("admin").isEmpty()) {
            User admin = new User("admin", "admin123", "Admin", "admin@cookapp.com", User.Role.ADMIN);
            userDAO.saveUser(admin);
        }
    }
}