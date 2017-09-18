package com.cooksys.robots.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.robots.dto.PartDto;
import com.cooksys.robots.dto.RobotDto;
import com.cooksys.robots.service.RobotService;

@RestController
@RequestMapping("robot")
public class RobotController {

	private RobotService robotService;

	public RobotController(RobotService robotService) {
		this.robotService = robotService;
	}
	
	@GetMapping
	public List<RobotDto> getRobots() {
		return robotService.getAll();
	}
	
	@GetMapping("{id}")
	public RobotDto getRobotById(@PathVariable Integer id) {
		return robotService.get(id);
	}
	
	@PostMapping
	public RobotDto createRobot(@RequestBody RobotDto robot) {
		return robotService.create(robot);
	}
	
	@PostMapping("{robotId}/parts/{partId}")
	public void attachPart(@PathVariable Integer robotId, @PathVariable Integer partId) {
		robotService.attachPart(robotId, partId);
	}
	
	@GetMapping("{robotId}/parts")
	public List<PartDto> getParts(@PathVariable Integer robotId) {
		return robotService.getParts(robotId);
	}
}
