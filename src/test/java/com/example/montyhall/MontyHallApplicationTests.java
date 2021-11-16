package com.example.montyhall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class MontyHallApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testPlayMontyHall_Status200()
			throws Exception {
		ResultActions resultActions =  mvc.perform(MockMvcRequestBuilders.get("/playgame/v1"));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.jsonPath("$.numberOfGames").value(10000))
		.andExpect(MockMvcResultMatchers.jsonPath("$.stickWinProbability").isNumber())
		.andExpect(MockMvcResultMatchers.jsonPath("$.changeWinProbability").isNumber())
		.andReturn();

		resultActions =  mvc.perform(MockMvcRequestBuilders.get("/playgame/v1?limit=20000"));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.jsonPath("$.numberOfGames").value(20000))
		.andExpect(MockMvcResultMatchers.jsonPath("$.stickWinProbability").isNumber())
		.andExpect(MockMvcResultMatchers.jsonPath("$.changeWinProbability").isNumber())
		.andReturn();
	}

	@Test
	public void testPlayMontyHall_Invalidlimit_Status400()
			throws Exception {
		ResultActions resultActions =  mvc.perform(MockMvcRequestBuilders.get("/playgame/v1?limit=abc"));
		resultActions.andExpect(MockMvcResultMatchers.status().is(400))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
		
		resultActions =  mvc.perform(MockMvcRequestBuilders.get("/playgame/v1?limit=-2000"));
		resultActions.andExpect(MockMvcResultMatchers.status().is(400))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}

	@Test
	public void testPlayMontyHall_InvalidURL_Status404()
			throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/playmontygame/v1"))
		.andExpect(MockMvcResultMatchers.status().is(404))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}
}
