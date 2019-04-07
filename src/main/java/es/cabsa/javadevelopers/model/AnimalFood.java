package es.cabsa.javadevelopers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "animal_food", schema = "jungle")
public class AnimalFood
{

	@Id
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "animal_id")
	private AnimalEntity animal;
	@ManyToOne
	@JoinColumn(name = "food_id")
	private FoodEntity food;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public AnimalEntity getAnimal()
	{
		return animal;
	}

	public void setAnimal(AnimalEntity animal)
	{
		this.animal = animal;
	}

	public FoodEntity getFood()
	{
		return food;
	}

	public void setFood(FoodEntity food)
	{
		this.food = food;
	}

}
