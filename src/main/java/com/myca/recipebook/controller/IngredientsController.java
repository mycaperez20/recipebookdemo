package com.myca.recipebook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myca.recipebook.dto.IngredientsDto;
import com.myca.recipebook.mapper.IngredientsConverter;
import com.myca.recipebook.mapper.IngredientsDtoConverter;
import com.myca.recipebook.model.Ingredients;
import com.myca.recipebook.service.DishService;
import com.myca.recipebook.service.IngredientsService;

@RestController
@RequestMapping(value="/ingredient")
public class IngredientsController {

	@Autowired
	private DishService dishService;
	
	@Autowired
	private IngredientsService ingredientsService;
	
	@Autowired
	private IngredientsConverter ingredientsConverter;
	
	@Autowired
	private IngredientsDtoConverter ingredientsDtoConverter;
	
	@GetMapping(value ="/{id}")
	public IngredientsDto getIngredientById(@PathVariable Integer id) {
		Ingredients ingredients = ingredientsService.getIngredient(id);
		IngredientsDto dto = ingredientsDtoConverter.convert(ingredients);
		return dto;
	}
	
	
	@PostMapping(value = "/{dishId}")
	public IngredientsDto addIngredient(@RequestBody IngredientsDto newIngredients, @PathVariable Integer dishId) {
		Ingredients ingredients = ingredientsConverter.convert(newIngredients);
		Ingredients result = ingredientsService.addIngredient(ingredients, dishId);
		IngredientsDto dto =ingredientsDtoConverter.convert(result);
		return dto;
	}
	
	@PutMapping(value ="/{dishId}")
	public IngredientsDto updateIngredients(@RequestBody IngredientsDto newIngredients, @PathVariable Integer dishId) {
		Ingredients ingredients = ingredientsConverter.convert(newIngredients);
		Ingredients result = ingredientsService.updateIngredient(ingredients,dishId);
		IngredientsDto dto =ingredientsDtoConverter.convert(result);
		return dto;
	}
	
	@DeleteMapping(value ="/{id}")
	public IngredientsDto deleteIngredient(@PathVariable Integer id) {
		Ingredients result = ingredientsService.deleteIngredient(id);
		IngredientsDto dto =ingredientsDtoConverter.convert(result);
		return dto;
	}
	
}
