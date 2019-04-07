package es.cabsa.javadevelopers.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalFoodBean;
import es.cabsa.javadevelopers.model.AnimalEntity;
import es.cabsa.javadevelopers.model.AnimalFood;
import es.cabsa.javadevelopers.model.FoodEntity;
import es.cabsa.javadevelopers.repository.AnimalFoodRepository;
import es.cabsa.javadevelopers.repository.AnimalRepository;
import es.cabsa.javadevelopers.repository.FoodRepository;

@Service("animalFoodService")
@Transactional
public class AnimalFoodServiceImpl implements AnimalFoodService
{
	@Autowired
	AnimalFoodRepository animalFoodRepository;

	@Autowired
	FoodRepository foodRepository;

	@Autowired
	AnimalRepository animalRepository;

	@Override
	public ResponseEntity<List<AnimalFoodBean>> findAll()
	{
		List<AnimalFood> animalFoodList = animalFoodRepository.findAll();
		List<AnimalFoodBean> animalFoodBeanList = new ArrayList<>();
		for (AnimalFood animalFood : animalFoodList)
		{
			AnimalFoodBean animalFoodBean = new AnimalFoodBean();
			animalFoodBean.setAnimalName(animalFood.getAnimal().getName());
			animalFoodBean.setFoodName(animalFood.getFood().getName());
			animalFoodBeanList.add(animalFoodBean);
		}
		return new ResponseEntity<>(animalFoodBeanList, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<AnimalEntity> findAnimalByFood(String food)
	{
		FoodEntity foodEntity = foodRepository.findByName(food);
		if (foodEntity != null)
		{
			AnimalFood animalFood = animalFoodRepository.findByFoodId(foodEntity.getId());
			if (animalFood != null)
			{
				return new ResponseEntity<>(animalFood.getAnimal(), HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<AnimalEntity> findByName(String name)
	{
		AnimalEntity animalEntity = animalRepository.findByName(name);
		if (animalEntity != null)
		{
			return new ResponseEntity<>(animalEntity, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

}
