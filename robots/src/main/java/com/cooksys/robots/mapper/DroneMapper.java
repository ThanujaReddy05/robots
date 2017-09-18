package com.cooksys.robots.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.robots.dto.DroneDto;
import com.cooksys.robots.entity.Drone;

@Mapper(componentModel="spring")
public interface DroneMapper {

	DroneDto toDto(Drone drone);
	
	Drone fromDto(DroneDto dto);
	
	List<DroneDto> toDtos(List<Drone> drones);
	
}
