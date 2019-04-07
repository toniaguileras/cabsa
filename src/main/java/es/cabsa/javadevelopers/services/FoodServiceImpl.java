package es.cabsa.javadevelopers.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cabsa.javadevelopers.model.FoodEntity;
import es.cabsa.javadevelopers.repository.FoodRepository;

@Service("foodService")
@Transactional
public class FoodServiceImpl implements FoodService
{
	@Autowired
	FoodRepository foodRepository;

	@Override
	public Boolean createFood(FoodEntity foodEntity)
	{
		try
		{
			FoodEntity validateFood = foodRepository.findOneById(foodEntity.getId());
			if (validateFood == null)
			{

				foodRepository.save(foodEntity);
				return true;
			}
		} catch (Exception e)
		{
			return false;
		}
		return false;

	}

}
