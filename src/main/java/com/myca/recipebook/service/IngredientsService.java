package com.myca.recipebook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myca.recipebook.model.Dish;
import com.myca.recipebook.model.Ingredients;
import com.myca.recipebook.repository.DishRepository;
import com.myca.recipebook.repository.IngredientsRepository;

@Service
public class IngredientsService {

	@Autowired
	private IngredientsRepository ingredientsRepository;
	
	@Autowired
	private DishRepository dishRepository;
	
	
	public Ingredients getIngredient(Integer id) {
		Ingredients ingredients = ingredientsRepository.findById(id).get();
		return ingredients;
	}
	
	public Ingredients addIngredient(Ingredients newIngredients,Integer dishId) {
		Dish dish = dishRepository.findById(dishId).get();
		newIngredients.setDish(dish);
		ingredientsRepository.save(newIngredients);
		
		return newIngredients;
	}
	
	public Ingredients updateIngredient(Ingredients newIngredients,Integer dishId) {
		Ingredients ingredients = ingredientsRepository.findById(newIngredients.getId()).get();
		Dish dish = dishRepository.findById(dishId).get();
		ingredients.setDish(dish);
		ingredients.setName(newIngredients.getName());
		ingredients.setQty(newIngredients.getQty());
		ingredientsRepository.save(ingredients);

		return ingredients;
	}
	
	public Ingredients deleteIngredient(Integer id) {
		Ingredients ingredients = ingredientsRepository.findById(id).get();
		ingredientsRepository.deleteById(id);
		return ingredients;
	}
	
}
