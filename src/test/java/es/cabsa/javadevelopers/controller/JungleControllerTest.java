package es.cabsa.javadevelopers.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cabsa.javadevelopers.Application;
import es.cabsa.javadevelopers.model.FoodEntity;
import es.cabsa.javadevelopers.utils.URLConstants;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
@WebAppConfiguration
@Transactional
public class JungleControllerTest
{
	public MockMvc mockMvc;
	
	@Autowired
	protected WebApplicationContext webApplicationContext;


	@Before
	public void setUp()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)

				.build();
	}

	@Test
	public void testFindAnimals() throws Exception
	{
		mockMvc.perform(
				get(URLConstants.JUNGLE_ROOT + URLConstants.ANIMAL_ROOT).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(0))
				.andExpect(jsonPath("$[0].name").value("Rabbit")).andExpect(jsonPath("$[0].legs").value(4));
	}

	@Test
	public void testFindAnimalsWithItsFood() throws Exception
	{
		mockMvc.perform(get(URLConstants.JUNGLE_ROOT + URLConstants.ANIMAL_ROOT + URLConstants.FOOD_ROOT)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].animalName").value("Rabbit"))
				.andExpect(jsonPath("$[0].foodName").value("carrot"));
	}

	@Test
	public void testFindAnimalsByName() throws Exception
	{
		mockMvc.perform(get(URLConstants.JUNGLE_ROOT + URLConstants.ANIMAL_ROOT + URLConstants.NAME_PARAM, "Rabbit")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(0)).andExpect(jsonPath("$.name").value("Rabbit"))
				.andExpect(jsonPath("$.legs").value(4));
	}

	@Test
	public void testFindAnimalsByFood() throws Exception
	{
		mockMvc.perform(get(URLConstants.JUNGLE_ROOT + URLConstants.FOOD_ROOT + URLConstants.FOOD_PARAM, "carrot")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.id").value(0)).andExpect(jsonPath("$.name").value("Rabbit"))
				.andExpect(jsonPath("$.legs").value(4));
	}

	@Test
	public void testCreateFoodFail() throws Exception
	{
		FoodEntity foodEntity = new FoodEntity();
		foodEntity.setId(2);
		foodEntity.setName("Potatoes");
		String value = asJsonString(foodEntity);
		System.out.println(value);
		mockMvc.perform(post(URLConstants.JUNGLE_ROOT + URLConstants.FOOD_ROOT).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(foodEntity)).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().isBadRequest());
	}
	@Test
	public void testCreateFoodOk() throws Exception
	{
		FoodEntity foodEntity = new FoodEntity();
		foodEntity.setId(6);
		foodEntity.setName("Potatoes");
		String value = asJsonString(foodEntity);
		System.out.println(value);
		mockMvc.perform(post(URLConstants.JUNGLE_ROOT + URLConstants.FOOD_ROOT).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(foodEntity)).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj)
	{
		try
		{
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

}
