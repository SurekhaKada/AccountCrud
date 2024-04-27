package com.example.AccontService_Testing;

import static org.junit.jupiter.api.Assertions.*;


import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.AccontService_Testing.Account;
import com.example.AccontService_Testing.AccountController;
import com.example.AccontService_Testing.AccountService;

@WebMvcTest(AccountController.class)
public class ServiceTest {

//	@Autowired
//	private MockMvc mockMvc;
//
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountService service;
	
	
	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		
		when(service.print()).thenReturn("from service method for Wipro demo");
		this.mockMvc.perform(get("/greet"))//.andExpect(status().isOk());
		.andExpect(content().string(containsString("from service method")));
	}
	
	@Test
	public void testingTheSaveAccountMethod() throws Exception {
		Account acc = new Account(1,"kohli","savings account");
		//Employee emp = createEmployee();

		mockMvc.perform(post("/save")
		.contentType(MediaType.APPLICATION_JSON)
		.content(toJson(acc)))
		.andExpect(status().isOk());
		}
        
	

	public String toJson(Account a) {
		return "{'id' : 1,'accName' : 'kohli','accDesc' : 'savings account}";
	}
		
	
//	@Test
//	public void testgetListOfAccounts() {
//		List<Account> li = new ArrayList<>();
//		Account a1 = new Account(1,"kohli","savings Account");
//		li.add(a1);
//		when(service.getAccounts()).thenReturn(li);
//		this.mockMvc.perform(post("/save"))
//		.andExpect(content().)
//		
//	}

	
}