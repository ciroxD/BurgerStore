package com.tastyburguers;

import java.util.Arrays;

import com.tastyburguers.jwt.JwtUserDetailsService;
import com.tastyburguers.models.Meal;
import com.tastyburguers.models.Ingredient;
import com.tastyburguers.models.User;
import com.tastyburguers.repositories.MealRepository;
import com.tastyburguers.repositories.IngredientRepository;
import com.tastyburguers.repositories.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BurguerApplication {

	private static final boolean START_SEED = true;

	public static void main(String[] args) {
		SpringApplication.run(BurguerApplication.class, args);
	}

	@Bean
	CommandLineRunner initTeste(
		UserRepository userRepository,
		JwtUserDetailsService jwtUserDetailsService, 
		MealRepository mealRepository,
		IngredientRepository ingredientRepository) throws Exception{


		if(START_SEED) {

			//users
			User u1 = new User("name 01", "user01@finch", "name001","123");
			User u2 = new User("name 02", "user02@finch", "name002","123");
			User u3 = new User("name 03", "user03@finch", "name003","123");

			jwtUserDetailsService.register(u1);
			jwtUserDetailsService.register(u2);
			jwtUserDetailsService.register(u3);

			//ingredients
			Ingredient i1 = new Ingredient ("Alface",0.40);
			Ingredient i2 = new Ingredient ("Bacon",2.00);
			Ingredient i3 = new Ingredient ("Hambúrguer",3.00);
			Ingredient i4 = new Ingredient ("Ovo",0.80);
			Ingredient i5 = new Ingredient ("Queijo",1.50);

			//meals
			Meal m1 = new Meal("X-Bacon");
			Meal m2 = new Meal("X-Burger");
			Meal m3 = new Meal("X-Egg");
			Meal m4 = new Meal("X-Egg Bacon");

			//xbacon
			m1.getIngredients().addAll(Arrays.asList(i2,i3,i5));
			//xburguer
			m2.getIngredients().addAll(Arrays.asList(i3,i5));
			//xeggs
			m3.getIngredients().addAll(Arrays.asList(i3,i4,i5));
			//xeggsbacon
			m4.getIngredients().addAll(Arrays.asList(i2,i3,i4,i5));

			//i2.getMeals().addAll(Arrays.asList(m1,m4));
			//i3.getMeals().addAll(Arrays.asList(m1,m2,m3,m4));
			//i4.getMeals().addAll(Arrays.asList(m3,m4));
			//i5.getMeals().addAll(Arrays.asList(m1,m2,m3,m4));
			ingredientRepository.saveAll(Arrays.asList(i1,i2,i3,i4,i5));
			mealRepository.saveAll(Arrays.asList(m1,m2,m3,m4));
			


			
		}

		return null;
	}


}
