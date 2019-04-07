package es.cabsa.javadevelopers.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.cabsa.javadevelopers.model.AnimalEntity;
import es.cabsa.javadevelopers.repository.AnimalRepository;

@Service("animalService")
@Transactional
public class AnimalServiceImpl implements AnimalService
{
	@Autowired
	AnimalRepository animalRepository;

	@Override
	public ResponseEntity<List<AnimalEntity>> findAnimals()
	{
		return new ResponseEntity<>(animalRepository.findAll(), HttpStatus.OK);

	}

}
