package com.example.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// Inject MockMvc instance.
@SpringBootTest  // Create whole app context
@AutoConfigureMockMvc
public class BraguiaApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(get("/bye").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				//.andExpect(content().string(equalTo("{id: 1, content: Adeus, Sr. Anderson!}")));
	}
}
