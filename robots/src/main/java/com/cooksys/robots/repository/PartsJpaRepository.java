package com.cooksys.robots.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.robots.entity.Part;

public interface PartsJpaRepository extends JpaRepository<Part, Integer>{

	List<Part> findByOwningRobotsDirective(String directive);
	
}
