package com.tastyburguers.dtos;

import java.util.List;
import com.tastyburguers.models.Meal;

public class NewRequest {
    String clientName;
    List<Meal> meals;

    public String getClientName() {
        return clientName;
    }

    public void setName(String clientName) {
        this.clientName = clientName;
    }

    public List<Meal> getMeal() {
        return meals;
    }

    public void setMeal(List<Meal> meals) {
        this.meals= meals;
    }

    public NewRequest() {
    }

    public NewRequest(String clientName, List<Meal> meals) {
        this.clientName = clientName;
        this.meals = meals;
    }

}