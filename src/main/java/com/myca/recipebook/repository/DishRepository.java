package com.myca.recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myca.recipebook.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer>{

	
}
