package com.ferrin.cookapp.model;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000, nullable = false)
    private String ingredients;  // comma-separated values

    @Column(length = 2000)
    private String instructions;

    private int cookingTime; // in minutes

    private String cuisine;

    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;

    public Recipe() {
        // Required no-arg constructor for Hibernate
    }

    public Recipe(String name, String ingredients, String instructions,
                  int cookingTime, String cuisine,
                  boolean vegetarian, boolean vegan, boolean glutenFree) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
        this.cuisine = cuisine;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
    }

    // Simplified constructor for dummy data
    public Recipe(String name, String ingredients, String instructions,
                  int cookingTime, String cuisine, String dietaryTag) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
        this.cuisine = cuisine;
        this.vegetarian = dietaryTag.equalsIgnoreCase("Vegetarian") || dietaryTag.equalsIgnoreCase("Vegan");
        this.vegan = dietaryTag.equalsIgnoreCase("Vegan");
        this.glutenFree = dietaryTag.equalsIgnoreCase("Gluten-Free");
    }

    // Required Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
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

    public int getCookTime() {
        return cookingTime; // required for controller
    }

    public String getDietaryTag() {
        if (vegan) return "Vegan";
        if (vegetarian) return "Vegetarian";
        if (glutenFree) return "Gluten-Free";
        return "None";
    }

    public List<String> getIngredientList() {
        return Arrays.stream(ingredients.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    @Override
    public String toString() {
        return name;
    }
}
