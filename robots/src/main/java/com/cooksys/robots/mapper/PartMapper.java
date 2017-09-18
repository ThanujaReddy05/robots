package com.cooksys.robots.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.robots.dto.PartDto;
import com.cooksys.robots.entity.Part;

@Mapper(componentModel="spring")
public interface PartMapper {

	PartDto toDto(Part part);
	
	Part fromDto(PartDto dto);

	List<PartDto> toDtos(List<Part> parts);
	
}
