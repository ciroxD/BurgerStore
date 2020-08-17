package com.tastyburguers.services;

import java.util.Optional;

import com.tastyburguers.models.Meal;
import com.tastyburguers.repositories.MealRepository;
import com.tastyburguers.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    @Autowired
    private MealRepository repository;

    public Meal searchById(Integer id) {
        Optional <Meal> meal = repository.findById(id);
        return meal.orElseThrow(() -> new ObjectNotFoundException ("Object not found: " + id));
    }

    public Meal insert(Meal obj) {
        return repository.save(obj);
    }

    public Meal update(Meal obj) {
        searchById(obj.getId());
        return repository.save(obj);
    }
    
}