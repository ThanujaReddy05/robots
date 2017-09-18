package com.cooksys.robots.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.robots.dto.DroneDto;
import com.cooksys.robots.mapper.DroneMapper;
import com.cooksys.robots.repository.DroneRepository;

@Service
public class DroneService {

	private DroneRepository droneRepository;
	private DroneMapper droneMapper;

	public DroneService(DroneRepository droneRepository, DroneMapper droneMapper) {
		this.droneRepository = droneRepository;
		this.droneMapper = droneMapper;
	}
	
	public DroneDto create(DroneDto droneDto) {
		return droneMapper.toDto(droneRepository.save(droneMapper.fromDto(droneDto)));
	}
	
	public DroneDto findById(Integer id) {
		return droneMapper.toDto(droneRepository.findOne(id));
	}

	public List<DroneDto> findAll() {
		return droneMapper.toDtos(droneRepository.findAll());
	}

	public List<DroneDto> findByNicknameAndSerialNumber(String nickname, String serial) {
		// TODO Auto-generated method stub
		return droneMapper.toDtos(droneRepository.findByNicknameAndSerialNumber(nickname, Integer.valueOf(serial)));
	}

	public List<DroneDto> findByNickname(String nickname) {
		// TODO Auto-generated method stub
		return droneMapper.toDtos(droneRepository.findByNickname(nickname));
	}

	public List<DroneDto> findBySerial(String serial) {
		// TODO Auto-generated method stub
		return droneMapper.toDtos(droneRepository.findBySerialNumber(Integer.valueOf(serial)));
	}
	
	

}
