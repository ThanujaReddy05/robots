package com.cooksys.robots.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cooksys.robots.dto.RobotDto;
import com.cooksys.robots.entity.Robot;

@Repository
public class RobotRepository {

	private EntityManager entityManager;

	public RobotRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Robot> getAllRobots() {
		return entityManager.createQuery("FROM Robot", Robot.class).getResultList();
	}

	public Robot get(Integer id) {
		return entityManager.find(Robot.class, id);
	}

	@Transactional
	public Robot create(Robot robot) {
		entityManager.persist(robot);
		return robot;
	}

	@Transactional
	public void update(Robot modifiedRobot) {

	}

}
