package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Taco;

public interface TacoRepository extends JpaRepository<Taco, Integer>, JpaSpecificationExecutor<Taco> {

}
