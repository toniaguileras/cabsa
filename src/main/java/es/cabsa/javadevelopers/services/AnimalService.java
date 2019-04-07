package es.cabsa.javadevelopers.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import es.cabsa.javadevelopers.model.AnimalEntity;

public interface AnimalService
{

	ResponseEntity<List<AnimalEntity>> findAnimals();
}
