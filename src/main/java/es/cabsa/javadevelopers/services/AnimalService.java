package es.cabsa.javadevelopers.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalBean;

public interface AnimalService
{

	ResponseEntity<List<AnimalBean>> findAnimals();
}
