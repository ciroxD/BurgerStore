package com.tastyburguers.repositories;

import com.tastyburguers.models.Meal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository <Meal, Integer>{
    
}