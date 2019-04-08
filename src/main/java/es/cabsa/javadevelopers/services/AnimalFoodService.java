package es.cabsa.javadevelopers.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalBean;
import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalFoodBean;

public interface AnimalFoodService
{

	ResponseEntity<List<AnimalFoodBean>> findAll();

	ResponseEntity<AnimalBean> findAnimalByFood(String food);

	ResponseEntity<AnimalBean> findByName(String name);
}
