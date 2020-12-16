package com.myca.recipebook.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.myca.recipebook.dto.DishDto;
import com.myca.recipebook.dto.IngredientsDto;
import com.myca.recipebook.model.Dish;
import com.myca.recipebook.model.Ingredients;

@Component
public class DishDtoConverter implements Converter<Dish, DishDto> {

	@Override
	public DishDto convert(Dish source) {
		DishDto dishDto = new DishDto();
		if(source.getId() != null) {
			dishDto.setId(source.getId());
		}
		dishDto.setDishName(source.getDishName());

		List<IngredientsDto> list = new ArrayList<>();
		for (Ingredients item : source.getIngredients()) {
			
			IngredientsDto ingredientsDto = new IngredientsDto();
			if (item.getId() != null) {
				ingredientsDto.setId(item.getId());	
			}
			
			ingredientsDto.setName(item.getName());
			ingredientsDto.setQty(item.getQty());

			list.add(ingredientsDto);

		}
		dishDto.setIngredients(list);

		return dishDto;
	}

}
