package com.myca.recipebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myca.recipebook.model.Dish;
import com.myca.recipebook.model.Ingredients;
import com.myca.recipebook.repository.DishRepository;
import com.myca.recipebook.repository.IngredientsRepository;

@Service
public class DishService {

	@Autowired
	private DishRepository dishRepository;
	
	@Autowired IngredientsRepository ingredientsRepository;
	
	public Dish getDishById(Integer id) {
		return dishRepository.findById(id).get();
	}
	
	public List<Dish> getAllDish() {
		return dishRepository.findAll();
	}
	
	public Dish createDish(Dish dish) {
		Dish dishResult = dishRepository.save(dish);
		return dishResult;
	}
	
	public Dish updateDish(Dish newdish) {
		Dish currDish =dishRepository.findById(newdish.getId()).get();
		if(currDish !=null) {
			currDish.setDishName(newdish.getDishName());
			currDish.setIngredients(newdish.getIngredients());
			dishRepository.save(newdish);
		}else {
			createDish(newdish);
		}
		
		return currDish;
	}

	public Dish deleteDish(Integer id) {
		Dish currDish =dishRepository.findById(id).get();
		dishRepository.deleteById(id);
		
		return currDish;
	}

	
}
