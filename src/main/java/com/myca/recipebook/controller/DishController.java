package com.myca.recipebook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myca.recipebook.dto.DishDto;
import com.myca.recipebook.mapper.DishConverter;
import com.myca.recipebook.mapper.DishDtoConverter;
import com.myca.recipebook.model.Dish;
import com.myca.recipebook.service.DishService;


@RestController
@RequestMapping(value = "/dish")
public class DishController {
	
	
	@Autowired
	private DishConverter converter;

	
	@Autowired
	private DishService dishService;
	
	@Autowired
	private DishDtoConverter dtoConverter;

	@GetMapping(value="/{id}")
	public DishDto getDishById(@PathVariable Integer id) {
		Dish dish = dishService.getDishById(id);
		DishDto dto = dtoConverter.convert(dish);
		return dto;
	}
	
	@GetMapping()
	public List<DishDto> getDish() {
		// get all dish from services
		List<Dish> dish = dishService.getAllDish();

		// create array list with dishdto result
		List<DishDto> result = new ArrayList<>();
			
		//loop dishes.size
		for(int i = 0; i< dish.size(); i++) {
			//add items  in result use dtoconverter
			result.add(dtoConverter.convert(dish.get(i)));	
		}	
		//return result
		return result;		
	}

	
	@PostMapping()
	public DishDto addDish(@RequestBody @Valid DishDto newDish) {
		
		Dish dish = converter.convert(newDish);
		Dish result = dishService.createDish(dish);
		DishDto dto = dtoConverter.convert(result);
		
		return dto;
	}
	
	@PutMapping()
	public DishDto editDish(@RequestBody @Valid DishDto newDish) {
		Dish dish = converter.convert(newDish);
		Dish result = dishService.updateDish(dish);
		DishDto dto = dtoConverter.convert(result);
		return dto;
	}

	@DeleteMapping("/{id}")
	public DishDto deleteDish(@PathVariable Integer id) {
		Dish result = dishService.deleteDish(id);
		DishDto dto = dtoConverter.convert(result);
		return dto;
	}
	
}
