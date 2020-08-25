package genpact.hackthon.interview.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import genpact.hackthon.interview.entity.Book;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {


	private static final Logger logger = LoggerFactory.getLogger(BookControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void add()  {
		Book book = new Book();
		book.setName("Book 1");
		book.setQuantity(10);
		try {
			this.mockMvc
					.perform(MockMvcRequestBuilders.post("/book").content(asJsonString(book))
							.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated()).andDo(print()).andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
		} catch (Exception e) {
			logger.error("Test Case Failed at add");
			e.printStackTrace();
		}
	}

	@Test
	void getAll() {

		try {
			add();
			this.mockMvc.perform(MockMvcRequestBuilders.get("/book").accept(MediaType.APPLICATION_JSON)).andDo(print())
					.andExpect(status().isOk()).andDo(print()).andExpect(MockMvcResultMatchers.jsonPath("$*.id").exists());
		} catch (Exception e) {
			logger.error("Test Case Failed at getAll");
			e.printStackTrace();
		}
	}
	
	@Test
	void getById() {

		try {
			add();
			this.mockMvc.perform(MockMvcRequestBuilders.get("/book/1").accept(MediaType.APPLICATION_JSON)).andDo(print())
					.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
					.andExpect(MockMvcResultMatchers.jsonPath("$.id").isNotEmpty());
		} catch (Exception e) {
			logger.error("Test Case Failed at getAll");
			e.printStackTrace();
		}
	}
	
	@Test
	void deleteId() {
		try {
			add();
			this.mockMvc.perform(MockMvcRequestBuilders.delete("/book/1").accept(MediaType.APPLICATION_JSON)).andDo(print())
					.andExpect(status().isOk());
		} catch (Exception e) {
			logger.error("Test Case Failed at getAll");
			e.printStackTrace();
		}
	}


	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
