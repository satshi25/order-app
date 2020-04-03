package com.example.demo;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.example.demo.service.TacoService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OrderService orderService;
	
	@MockBean
	private TacoService tacoService;
	
	@Test
	public void getOrder_ShouldReturnOrder() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/app/order"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void createTaco_noBodyRequest_shouldReturnStatus400BadRequest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/app/create"))
		.andExpect(status().isBadRequest());
	}

	@Test
	public void createTaco_withTacoRequestBody_shouldReturnStatus400BadRequest() throws Exception {
		
		String requestBody = "{\"name\" : \"sampleName\"}";
		
		mockMvc.perform(MockMvcRequestBuilders.post("/app/create").content(requestBody))
		.andExpect(status().isOk());
	}
	
}
