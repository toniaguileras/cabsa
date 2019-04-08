package es.cabsa.javadevelopers.test;

import javax.transaction.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

@Transactional
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = { ApplicationConfig.class })
// @WebAppConfiguration
public class JungleControllerTest
{
//	private MockMvc mockMvc;

//	@Test
//	public void testFindAnimals()
//	{
//		mockMvc.perform(get(URLConstants.JUNGLE_ROOT + URLConstants.ANIMAL_ROOT).contentType(MediaType.APPLICATION_JSON)
//				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id").value(0))
//				.andExpect(jsonPath("$[0].name").value("Rabbit")).andExpect(jsonPath("$[0].legs").value(4)));
//	}
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
