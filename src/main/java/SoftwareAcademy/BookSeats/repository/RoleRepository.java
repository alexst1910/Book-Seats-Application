package SoftwareAcademy.BookSeats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SoftwareAcademy.BookSeats.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
}
