package com.cooksys.robots.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.robots.entity.Drone;

public interface DroneRepository extends JpaRepository<Drone, Integer> {

	List<Drone> findByNicknameAndSerialNumber(String nickname, Integer serial);

	List<Drone> findByNickname(String nickname);

	List<Drone> findBySerialNumber(Integer serial);
	
	List<Drone> findByRobotDirective(String directive);

}
