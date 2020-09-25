package webservice.moneyback.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import webservice.moneyback.controller.LoanController;
import webservice.moneyback.entity.User;
import webservice.moneyback.service.LoanService;

@WebMvcTest(LoanController.class)
class LoanControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private LoanService loanService;

	@Test
	void getUsers_test() throws Exception {
		
		
		when(loanService.getUsers()).thenReturn(
				Arrays.asList(
						new User(1,"User1","Surname1","email1","tel1"),
						new User(2,"User2","Surname2","email2","tel2")
				));
		RequestBuilder request = MockMvcRequestBuilders
				.get("/users")
				.accept(MediaType.APPLICATION_JSON); // tell server what client want in the response
		
			MvcResult result = mockMvc.perform(request)
					.andExpect(status().isOk())
					.andExpect(content().json("[{id:1,name:User1,surname:Surname1,email:email1,tel:tel1},{id:2,name:User2,surname:Surname2,email:email2,tel:tel2}]")) 
					.andReturn();
		
	}

}
