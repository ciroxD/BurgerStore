package com.tastyburguers.services;

import java.util.Optional;

import com.tastyburguers.models.Ingredient;
import com.tastyburguers.repositories.IngredientRepository;
import com.tastyburguers.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository repository;

    public Ingredient searchById(Integer id) {
        Optional <Ingredient> ingredient = repository.findById(id);
        return ingredient.orElseThrow(() -> new ObjectNotFoundException ("Object not found: " + id));
    }

    public Ingredient insert(Ingredient obj) {
        return repository.save(obj);
    }

    public Ingredient update(Ingredient obj) {
        searchById(obj.getId());
        return repository.save(obj);
    }
    
}