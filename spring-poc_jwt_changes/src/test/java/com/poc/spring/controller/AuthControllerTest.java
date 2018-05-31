package com.poc.spring.controller;

import java.util.UUID;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.poc.spring.model.User;
import com.poc.spring.payload.SignUpRequest;
import com.poc.spring.repository.UserRepository;
import org.hamcrest.Matchers;

@RunWith(SpringJUnit4ClassRunner.class)
public class AuthControllerTest {
	private MockMvc mockMvc;

	@InjectMocks
	AuthController authController;

	@Mock
	private UserRepository userRepository;

	User user=new User(UUID.randomUUID().toString(), "test");

	
	
	@Before
	public void setUp() {
		 //RestAssured.baseURI = "https://localhost";
		mockMvc =MockMvcBuilders.standaloneSetup(authController).build();
	
}
	@Test
	public void createStudentCourse() throws Exception {
		//SignUpRequest user=new User(UUID.randomUUID().toString(), "test1");

		//mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/signup"))
		  String json = "{\n" +  "\"uid\": \"1234\"\n" +
	                "  \"password\": \"1234\"\n" +
	"}";
		mockMvc.perform(get("/api/auth/users").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())

		
		/* mockMvc.perform(post("/hello/post")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(json))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
	                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
	.andExpect(jsonPath("$.*", Matchers.hasSize(2)));*/

	;
		
		
		
		
		// studentService.addCourse to respond back with mockCourse

		/*// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/students/Student1/courses")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/students/Student1/courses/1",
				response.getHeader(HttpHeaders.LOCATION));*/

	}

}
