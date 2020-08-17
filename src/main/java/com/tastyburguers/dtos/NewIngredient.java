package com.tastyburguers.dtos;

public class NewIngredient {
    String name;
    Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public NewIngredient(){
        
    }

    public NewIngredient(String name, Double price) {
        this.name = name;
        this.price = price;
    }


}