package es.cabsa.javadevelopers.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cabsa.javadevelopers.model.FoodEntity;
import es.cabsa.javadevelopers.repository.FoodRepository;

@Service("foodService")
@Transactional
public class FoodServiceImpl implements FoodService
{
	@Autowired
	FoodRepository foodRepository;

	@Override
	public ResponseEntity<Boolean> createFood(FoodEntity foodEntity)
	{
		try
		{
			FoodEntity validateFood = foodRepository.findOneById(foodEntity.getId());
			if (validateFood == null)
			{

				foodRepository.save(foodEntity);
				return new ResponseEntity<>(true, HttpStatus.OK);
			}
		} catch (Exception e)
		{
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);

	}

}
