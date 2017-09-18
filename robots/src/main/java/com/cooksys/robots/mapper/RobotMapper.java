package com.cooksys.robots.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.robots.dto.RobotDto;
import com.cooksys.robots.entity.Robot;

@Mapper(componentModel="spring")
public interface RobotMapper {

	Robot fromDto(RobotDto dto);
	
	RobotDto toDto(Robot robot);
	
	List<RobotDto> toDtos(List<Robot> robots);
	
}
