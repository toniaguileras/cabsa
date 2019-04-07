package es.cabsa.javadevelopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cabsa.javadevelopers.model.AnimalFood;

public interface AnimalFoodRepository extends JpaRepository<AnimalFood, Integer>
{

	AnimalFood findByFoodId(Integer id);
}
