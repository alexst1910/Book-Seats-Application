package SoftwareAcademy.BookSeats.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="booking")
public class BookingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private Long id;
	
	@Column
	private LocalDate date;
	
	@Column(name="time_from")
	private LocalTime timeFrom;
	
	@Column(name="time_to")
	private LocalTime timeTo;
	
	@Column
	private Integer seats;
}
