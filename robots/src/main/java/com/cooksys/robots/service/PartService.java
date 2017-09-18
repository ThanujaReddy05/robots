package com.cooksys.robots.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.robots.dto.PartDto;
import com.cooksys.robots.entity.Part;
import com.cooksys.robots.mapper.PartMapper;
import com.cooksys.robots.repository.PartRepository;
import com.cooksys.robots.repository.PartsJpaRepository;

@Service
public class PartService {

	private PartRepository partRepository;
	private PartMapper partMapper;
	private PartsJpaRepository partJpaRepository;

	public PartService(PartsJpaRepository partJpaRepository, PartRepository partRepository, PartMapper partMapper) {
		this.partRepository = partRepository;
		this.partMapper = partMapper;
		this.partJpaRepository = partJpaRepository;
	}
	
	public List<Integer> getSerialNumbers() {
		// TODO Auto-generated method stub
		return partRepository.getSerialNumbers();
	}

	public PartDto create(PartDto part) {
		return partMapper.toDto(partRepository.create(partMapper.fromDto(part)));
	}

	public List<PartDto> findByDirective(String directive) {
		// TODO Auto-generated method stub
		return partMapper.toDtos(partJpaRepository.findByOwningRobotsDirective(directive));
	}

}
