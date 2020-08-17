package com.tastyburguers.controllers;

import com.tastyburguers.dtos.NewIngredient;
import com.tastyburguers.models.Ingredient;
import com.tastyburguers.services.IngredientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/ingredient")
public class IngredientController {
    
    @Autowired
    private IngredientService ingredientService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ingredient> get(@PathVariable Integer id) throws Exception {
        Ingredient ingredient = ingredientService.searchById(id);
        return ResponseEntity.ok(ingredient);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Ingredient> register(@RequestBody NewIngredient model) throws Exception {
        Ingredient ingredient = new Ingredient(model.getName(),model.getPrice());
		return ResponseEntity.ok(ingredientService.insert(ingredient));
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Ingredient> update(@RequestBody NewIngredient model, @PathVariable Integer id) throws Exception {
        Ingredient ingredient = new Ingredient(model.getName(),model.getPrice());
        ingredient.setId(id);
		return ResponseEntity.ok(ingredientService.update(ingredient));
	}

    
}