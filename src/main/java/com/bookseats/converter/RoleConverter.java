package com.bookseats.converter;

import com.bookseats.dto.RoleDTO;
import com.bookseats.entity.RoleEntity;

public class RoleConverter {

	public static RoleDTO toDto(RoleEntity roleEntity) {
		RoleDTO dto=new RoleDTO();
		
		dto.setRoleId(roleEntity.getRoleId());
		dto.setRole(roleEntity.getRole());
		return dto;
	}
	
	public static RoleEntity toEntity(RoleDTO roleDto) {
		RoleEntity entity=new RoleEntity();
		
		entity.setRole(roleDto.getRole());
		return entity;
	}
}
	
	
