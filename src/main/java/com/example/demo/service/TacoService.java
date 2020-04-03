package com.example.demo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Taco;
import com.example.demo.repository.TacoRepository;

@Service
@Validated
public class TacoService {

	@Autowired
	private TacoRepository repository;
	
	public void saveTaco(@Valid Taco taco) {
		repository.save(taco);
	}
	
	
}
