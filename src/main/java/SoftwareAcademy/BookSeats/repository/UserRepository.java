package SoftwareAcademy.BookSeats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SoftwareAcademy.BookSeats.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
