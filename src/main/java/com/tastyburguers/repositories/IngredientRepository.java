package com.tastyburguers.repositories;

import com.tastyburguers.models.Ingredient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository <Ingredient, Integer>{
    
}