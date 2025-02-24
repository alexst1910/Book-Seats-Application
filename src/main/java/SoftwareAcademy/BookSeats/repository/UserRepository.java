package SoftwareAcademy.BookSeats.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SoftwareAcademy.BookSeats.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	public List<UserEntity> findAllByFirstNameContaining(String firstName);
	public Optional<UserEntity> findByUsername(String username);
}
