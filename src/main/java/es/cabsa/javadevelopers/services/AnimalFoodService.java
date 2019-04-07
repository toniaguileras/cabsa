package es.cabsa.javadevelopers.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalFoodBean;
import es.cabsa.javadevelopers.model.AnimalEntity;

public interface AnimalFoodService
{

	ResponseEntity<List<AnimalFoodBean>> findAll();

	ResponseEntity<AnimalEntity> findAnimalByFood(String food);

	ResponseEntity<AnimalEntity> findByName(String name);
}
