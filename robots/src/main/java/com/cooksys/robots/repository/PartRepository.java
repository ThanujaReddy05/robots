package com.cooksys.robots.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cooksys.robots.entity.Part;

@Repository
public class PartRepository {

	private EntityManager entityManager;

	public PartRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Integer> getSerialNumbers() {
		return entityManager.createQuery("SELECT serialNumber FROM Part").getResultList();
	}

	@Transactional
	public Part create(Part part) {
		entityManager.persist(part);
		return part;
	}

	public Part get(Integer partId) {
		return entityManager.find(Part.class, partId);
	}
	
}
