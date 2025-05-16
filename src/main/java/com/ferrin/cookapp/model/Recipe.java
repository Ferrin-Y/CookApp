package com.ferrin.cookapp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String instructions;

    @Column(name = "cooking_time")
    private int cookingTime; // in minutes

    private String cuisine;

    private boolean vegetarian;
    private boolean vegan;

    @Column(name = "gluten_free")
    private boolean glutenFree;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Quantity> quantities;

    public Recipe() {
        // Required no-arg constructor for Hibernate
    }

    public Recipe(String name, String instructions, int cookingTime, String cuisine,
                  boolean vegetarian, boolean vegan, boolean glutenFree) {
        this.name = name;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
        this.cuisine = cuisine;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
    }

    // Simplified constructor for dummy data
    public Recipe(String name, String instructions, int cookingTime, String cuisine, String dietaryTag) {
        this.name = name;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
        this.cuisine = cuisine;
        this.vegetarian = dietaryTag.equalsIgnoreCase("Vegetarian") || dietaryTag.equalsIgnoreCase("Vegan");
        this.vegan = dietaryTag.equalsIgnoreCase("Vegan");
        this.glutenFree = dietaryTag.equalsIgnoreCase("Gluten-Free");
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public List<Quantity> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Quantity> quantities) {
        this.quantities = quantities;
        if (quantities != null) {
            for (Quantity q : quantities) {
                q.setRecipe(this); // maintain bidirectional relationship
            }
        }
    }

    public String getDietaryTag() {
        if (vegan) return "Vegan";
        if (vegetarian) return "Vegetarian";
        if (glutenFree) return "Gluten-Free";
        return "None";
    }

    @Override
    public String toString() {
        return name;
    }
}
