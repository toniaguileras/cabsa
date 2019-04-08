package es.cabsa.javadevelopers.services;

import org.springframework.http.ResponseEntity;

import es.cabsa.javadevelopers.model.FoodEntity;

public interface FoodService
{

	ResponseEntity<Boolean> createFood(FoodEntity foodEntity);
}
