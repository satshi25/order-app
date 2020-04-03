package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Order;
import com.example.demo.entity.Taco;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.TacoRepository;
import com.example.demo.service.TacoService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class OrderRepositoryTest {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private TacoRepository tacoRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@MockBean
	private TacoService tacoService;

	@Test
	public void getOrderTest_returnsOrder() {
		List<Taco> tacoList = new ArrayList<Taco>();
		Taco mockTaco = new Taco();
		mockTaco.setName("validTacoName");
		HashSet<Ingredient> ingredients = new HashSet<Ingredient>();
		ingredients.add(new Ingredient("beef"));
		mockTaco.setIngredients(ingredients);
		
		Taco mockTaco2 = new Taco();
		mockTaco.setName("validTacoName2");
		HashSet<Ingredient> ingredients2 = new HashSet<Ingredient>();
		ingredients2.add(new Ingredient("beef2"));
		mockTaco2.setIngredients(ingredients2);
		
		tacoList.add(mockTaco);
		tacoList.add(mockTaco2);
		
		
		Order mockOrder = new Order();
		
		
		orderRepository.save(mockOrder);
		entityManager.flush();
		
		List<Order> orderResult = orderRepository.findAll();
		assertThat(orderResult.isEmpty()).isEqualTo(false);
	}
	
}
