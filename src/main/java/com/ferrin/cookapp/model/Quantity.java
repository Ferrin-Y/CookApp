package com.ferrin.cookapp.model;

import javax.persistence.*;

@Entity
public class Quantity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private String amount;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Quantity() {}

    public Quantity(Ingredient ingredient, String amount, Recipe recipe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
