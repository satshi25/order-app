package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.Taco;
import com.example.demo.service.OrderService;
import com.example.demo.service.TacoService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TacoServiceTest {

	@MockBean
	private OrderService orderService;
	
	@Autowired
	private TacoService tacoService;
	
	
	@Test
	void whenInputIsInvalid_emptyName_thenThrowsException() {
		Taco tacoInput = new Taco();
		tacoInput.setName("");
		
		assertThrows(ConstraintViolationException.class, () -> {
			tacoService.saveTaco(tacoInput);
		});
		
	}
	
	@Test
	void whenInputIsInvalid_nameLength_thenThrowsException() {
		Taco tacoInput = new Taco();
		tacoInput.setName("taco");
		
		assertThrows(ConstraintViolationException.class, () -> {
			tacoService.saveTaco(tacoInput);
		});
		
	}
	
	@Test
	void whenInputIsInvalid_withEmptyIngredient_thenThrowsException() {
		Taco tacoInput = new Taco();
		tacoInput.setName("validTacoName");
		
		assertThrows(ConstraintViolationException.class, () -> {
			tacoService.saveTaco(tacoInput);
		});
		
	}
	
}
