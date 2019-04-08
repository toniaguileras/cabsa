package es.cabsa.javadevelopers.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalBean;
import es.cabsa.javadevelopers.model.AnimalEntity;
import es.cabsa.javadevelopers.repository.AnimalRepository;

@Service("animalService")
@Transactional
public class AnimalServiceImpl implements AnimalService
{
	@Autowired
	AnimalRepository animalRepository;

	@Override
	public ResponseEntity<List<AnimalBean>> findAnimals()
	{
		List<AnimalEntity> animals = animalRepository.findAll();
		List<AnimalBean> animalBeanList = new ArrayList<>();
		for(AnimalEntity animal : animals) {
			AnimalBean animalBean = new AnimalBean();
			animalBean.setId(animal.getId());
			animalBean.setLegs(animal.getLegs());
			animalBean.setName(animal.getName());
			animalBeanList.add(animalBean);
		}
		return new ResponseEntity<>(animalBeanList, HttpStatus.OK);

	}

}
