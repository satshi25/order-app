package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.example.demo.service.TacoService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TacoOrderDemoApplicationIntegration {

	@Autowired
	TestRestTemplate restTemplate;
	
	@MockBean
	OrderService orderService;
	
	@MockBean
	TacoService tacoService;
	
	@Test
	public void getOrderTest() {
		ResponseEntity<String> response = restTemplate.getForEntity("/app/order", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void createTacoTest() {
		String requestPayload = "{\"name\" : \"chickenTaco\","
				+ "\"ingredients\": [{\"name\" :\"chicken\" }]}";
		ResponseEntity<String> response = restTemplate.postForEntity("/app/create", requestPayload, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
