package es.cabsa.javadevelopers.test;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.jboss.jandex.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cabsa.javadevelopers.utils.URLConstants;


@Transactional
 @RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Main.class})
 @WebAppConfiguration
public class JungleControllerTest
{
	private MockMvc mockMvc;

	@Test
	public void testFindAnimals()
	{
		mockMvc.perform(get(URLConstants.JUNGLE_ROOT + URLConstants.ANIMAL_ROOT).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(0))
				.andExpect(jsonPath("$[0].name").value("Rabbit")).andExpect(jsonPath("$[0].legs").value(4));
	}
//
//	@Test
//	public void testFindAnimalsWithItsFood()
//	{
//		mockMvc.perform(get(URLConstants.JUNGLE_ROOT + URLConstants.ANIMAL_ROOT + URLConstants.FOOD_ROOT)
//				.contentType(MediaType.APPLICATION_JSON).andExpect(status().isOk())
//				.andExpect(jsonPath("$[0].animalName").value("Rabbit"))
//				.andExpect(jsonPath("$[0].foodName").value("carrot")));
//	}
//	@Test
//	public void testFindAnimalsByName() {
//		mockMvc.perform(get(URLConstants.JUNGLE_ROOT + URLConstants.ANIMAL_ROOT + URLConstants.NAME_PARAM, "Rabbit")
//				.contentType(MediaType.APPLICATION_JSON)
//				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(0))
//				.andExpect(jsonPath("$[0].name").value("Rabbit"))
//				.andExpect(jsonPath("$[0].legs").value(4)));
//	}
//
//	@Test
//	public void testFindAnimalsByFood() {
//		mockMvc.perform(get(URLConstants.JUNGLE_ROOT + URLConstants.FOOD_ROOT + URLConstants.FOOD_PARAM, "carrot")
//				.contentType(MediaType.APPLICATION_JSON)
//				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(0))
//				.andExpect(jsonPath("$[0].name").value("Rabbit"))
//				.andExpect(jsonPath("$[0].legs").value(4)));
//	}
//	
//	@Test
//	public void testCreateFood() {
//		FoodEntity foodEntity = new FoodEntity();
//		foodEntity.setId(9);
//		foodEntity.setName("Potatoes");
//		mockMvc.perform(post(URLConstants.JUNGLE_ROOT + URLConstants.FOOD_ROOT)
//				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(foodEntity))
//				.andExpect(status().isOk()).andExpect(true));
//	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
