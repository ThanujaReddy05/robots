package com.cooksys.robots.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.robots.dto.PartDto;
import com.cooksys.robots.entity.Part;
import com.cooksys.robots.service.PartService;

@RestController
@RequestMapping("part")
public class PartController {

	private PartService partService;

	public PartController(PartService partService) {
		this.partService = partService;
	}
	
	@GetMapping("/serial")
	public List<Integer> getAllSerialNumbers() {
		return partService.getSerialNumbers();
	}
	
	@PostMapping()
	public void createPart(@RequestBody PartDto part) {
		partService.create(part);
	}
	
	@GetMapping("/directive")
	public List<PartDto> getPartsByRobotDirective(@RequestParam String directive) {
		return partService.findByDirective(directive);
	}
}
