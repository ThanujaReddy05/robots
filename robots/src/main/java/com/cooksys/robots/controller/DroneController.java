package com.cooksys.robots.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.robots.dto.DroneDto;
import com.cooksys.robots.service.DroneService;

@RestController
@RequestMapping("drone")
public class DroneController {

	
	private DroneService droneService;

	public DroneController(DroneService droneService) {
		this.droneService = droneService;
	}
	
	@PostMapping
	public DroneDto create(@RequestBody DroneDto droneDto) {
		return droneService.create(droneDto);
	}
	
	@GetMapping
	public List<DroneDto> get(@RequestParam(required = false) String nickname, @RequestParam(required = false) String serial) {
		
		if(nickname != null && serial != null)
			return droneService.findByNicknameAndSerialNumber(nickname, serial);
		else if(nickname != null)
			return droneService.findByNickname(nickname);
		else if(serial != null)
			return droneService.findBySerial(serial);
		
		return droneService.findAll();
		
		
	}
	
	@GetMapping("{id}")
	public DroneDto getById(@PathVariable Integer id) {
		return droneService.findById(id);
	}
	
}
