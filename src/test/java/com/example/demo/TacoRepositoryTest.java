package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.Ingredient;
import com.example.demo.entity.Taco;
import com.example.demo.repository.TacoRepository;
import com.example.demo.service.TacoService;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TacoRepositoryTest {

	@Autowired
	private TacoRepository tacoRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@MockBean
	private TacoService tacoService;

	
	@Test
	public void saveTacoTest_returnsTaco() {
		HashSet<Ingredient> ingredients = new HashSet<>();
		ingredients.add(new Ingredient("chicken"));
		
		Taco mockTaco = new Taco();
		mockTaco.setName("validTacoName");
		mockTaco.setIngredients(ingredients);
		
		tacoRepository.save(mockTaco);
		entityManager.flush();
		
		List<Taco> result = tacoRepository.findAll();
		entityManager.flush();
		assertThat(result.isEmpty()).isEqualTo(false);
		assertThat(result.get(1).getName()).isEqualTo("validTacoName");
	}
	
	
	@Test
	public void saveTacoTest_withMultipleIngredients_returnsTaco() {
		HashSet<Ingredient> ingredients = new HashSet<Ingredient>();
		Ingredient mockIngredient = new Ingredient("chicken");
		Ingredient mockIngredient2 = new Ingredient("salsa");
		ingredients.add(mockIngredient);
		ingredients.add(mockIngredient2);
		
		Taco mockTaco = new Taco();
		mockTaco.setName("validTacoName");
		mockTaco.setIngredients(ingredients);
		
		tacoRepository.save(mockTaco);
		entityManager.flush();
		
		List<Taco> result = tacoRepository.findAll();
		entityManager.flush();
		
		assertThat(result.isEmpty()).isEqualTo(false);
		assertThat(result.get(1).getName()).isEqualTo("validTacoName");
		
	}
}
