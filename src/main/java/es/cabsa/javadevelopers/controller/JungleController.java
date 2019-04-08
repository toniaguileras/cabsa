package es.cabsa.javadevelopers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalBean;
import es.cabsa.javadevelopers.es.cabsa.javadevelopers.dto.AnimalFoodBean;
import es.cabsa.javadevelopers.model.FoodEntity;
import es.cabsa.javadevelopers.services.AnimalFoodService;
import es.cabsa.javadevelopers.services.AnimalService;
import es.cabsa.javadevelopers.services.FoodService;
import es.cabsa.javadevelopers.utils.URLConstants;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URLConstants.JUNGLE_ROOT)
public class JungleController
{
	@Autowired
	AnimalService animalService;
	@Autowired
	AnimalFoodService animalFoodService;

	@Autowired
	FoodService foodService;

	/**
	 * Este metodo devuelve una lista con todos los animales de la base de datos
	 * @return arraylist
	 */
	@RequestMapping(method = RequestMethod.GET, value = URLConstants.ANIMAL_ROOT)
	public ResponseEntity<List<AnimalBean>> findAnimals()
	{
		return animalService.findAnimals();

	}

	/**
	 * Este metodo devuelve una lista con el nombre del animal y con la comida que come 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = URLConstants.ANIMAL_ROOT + URLConstants.FOOD_ROOT)
	public ResponseEntity<List<AnimalFoodBean>> findAnimalsWithItsFood()
	{
		return animalFoodService.findAll();

	}

	/**
	 * Este metodo devuelve  un animal buscado por su nombre
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = URLConstants.ANIMAL_ROOT + URLConstants.NAME_PARAM)
	public ResponseEntity<AnimalBean> findAnimalsByName(@PathVariable("name") String name)
	{
		return animalFoodService.findByName(name);

	}

	/**
	 * Este metodo devuelve un animal encontrado por lo que come
	 * @param food
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = URLConstants.FOOD_ROOT + URLConstants.FOOD_PARAM)
	public ResponseEntity<AnimalBean> findAnimalsByFood(@PathVariable("food") String food)
	{
		return animalFoodService.findAnimalByFood(food);

	}

	/**
	 * Este metodo devuelve un boolean dependiendo de como haya ido la funcion de añadir una nueva comida
	 * @param foodEntity
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = URLConstants.FOOD_ROOT)
	public ResponseEntity<Boolean> createFood(@RequestBody FoodEntity foodEntity)
	{
		return foodService.createFood(foodEntity);

	}

}
