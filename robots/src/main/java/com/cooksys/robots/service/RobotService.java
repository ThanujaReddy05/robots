package com.cooksys.robots.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cooksys.robots.dto.PartDto;
import com.cooksys.robots.dto.RobotDto;
import com.cooksys.robots.entity.Robot;
import com.cooksys.robots.mapper.PartMapper;
import com.cooksys.robots.mapper.RobotMapper;
import com.cooksys.robots.repository.PartRepository;
import com.cooksys.robots.repository.RobotRepository;

@Service
public class RobotService {

	private RobotRepository robotRepository;
	private RobotMapper robotMapper;
	private PartRepository partRepository;
	private PartMapper partMapper;

	public RobotService(PartRepository partRepository, PartMapper partMapper, RobotRepository robotRepository, RobotMapper robotMapper) {
		this.robotRepository = robotRepository;
		this.robotMapper = robotMapper;
		this.partRepository = partRepository;
		this.partMapper = partMapper;
	}

	public List<RobotDto> getAll() {
		return robotMapper.toDtos(robotRepository.getAllRobots());
	}

	public RobotDto get(Integer id) {
		// TODO Auto-generated method stub
		return robotMapper.toDto(robotRepository.get(id));
	}

	public RobotDto create(RobotDto robot) {
		return robotMapper.toDto(robotRepository.create(robotMapper.fromDto(robot)));
	}

	@Transactional
	public void attachPart(Integer robotId, Integer partId) {

		Robot modifiedRobot = robotRepository.get(robotId);
		
		modifiedRobot.getParts().add(partRepository.get(partId));
	}

	public List<PartDto> getParts(Integer robotId) {
		return partMapper.toDtos(robotRepository.get(robotId).getParts());
	}
	
}
