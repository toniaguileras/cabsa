package es.cabsa.javadevelopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cabsa.javadevelopers.model.FoodEntity;

public interface FoodRepository extends JpaRepository<FoodEntity, Integer>
{

	FoodEntity findByName(String name);

	FoodEntity findOneById(Integer id);
}
