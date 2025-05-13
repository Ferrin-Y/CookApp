package com.ferrin.cookapp.service;

import com.ferrin.cookapp.dao.QuantityDAO;
import com.ferrin.cookapp.model.Quantity;

import java.util.List;

public class QuantityService {

    private final QuantityDAO quantityDAO = new QuantityDAO();

    public void saveQuantity(Quantity quantity) {
        quantityDAO.saveQuantity(quantity);
    }

    public List<Quantity> getQuantitiesForRecipe(Long recipeId) {
        return quantityDAO.getQuantitiesForRecipe(recipeId);
    }
}
