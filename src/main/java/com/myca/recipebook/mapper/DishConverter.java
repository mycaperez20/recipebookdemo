package com.myca.recipebook.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.myca.recipebook.dto.DishDto;
import com.myca.recipebook.dto.IngredientsDto;
import com.myca.recipebook.model.Dish;
import com.myca.recipebook.model.Ingredients;

@Component
public class DishConverter implements Converter<DishDto, Dish>{

	@Override
	public Dish convert(DishDto source) {
		Dish dish = new Dish();
		if(source.getId() != null) {
			dish.setId(source.getId());
		}
		dish.setDishName(source.getDishName());

		Set<Ingredients> sets = new HashSet<>();
		for (IngredientsDto item : source.getIngredients()) {
			
			Ingredients ingredients = new Ingredients();
			if(item.getId() != null) {
				ingredients.setId(item.getId());
			}
			ingredients.setName(item.getName());
			ingredients.setQty(item.getQty());

			sets.add(ingredients);
		}
		dish.setIngredients(sets);
		return dish;
	}

}
