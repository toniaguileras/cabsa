package es.cabsa.javadevelopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cabsa.javadevelopers.model.AnimalEntity;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer>
{
	AnimalEntity findByName(String name);
}
