package SoftwareAcademy.BookSeats.converter;

import SoftwareAcademy.BookSeats.dto.RoleDTO;
import SoftwareAcademy.BookSeats.entity.RoleEntity;

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
	
	
