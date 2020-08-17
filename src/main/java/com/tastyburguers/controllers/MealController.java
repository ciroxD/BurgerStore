package com.tastyburguers.controllers;

import com.tastyburguers.dtos.NewMeal;
import com.tastyburguers.models.Meal;
import com.tastyburguers.services.MealService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/meals")
public class MealController {
    
    @Autowired
    private MealService mealService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Meal> get(@PathVariable Integer id) throws Exception {
        Meal meal = mealService.searchById(id);
        return ResponseEntity.ok(meal);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Meal> saveUser(@RequestBody NewMeal model) throws Exception {
        Meal meal = new Meal(model.getName(), model.getIngredients());
		return ResponseEntity.ok(mealService.insert(meal));
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Meal> update(@RequestBody Meal meal, @PathVariable Integer id) throws Exception {
        meal.setId(id);
		return ResponseEntity.ok(mealService.update(meal));
	}

    
}