package com.tastyburguers.dtos;

import java.util.List;

import com.tastyburguers.models.Ingredient;

public class NewMeal {
    String name;
    List<Ingredient> ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public NewMeal() {
    }

    public NewMeal(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

}