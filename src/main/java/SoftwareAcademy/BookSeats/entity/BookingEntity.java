package SoftwareAcademy.BookSeats.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@Table(name="booking")
public class BookingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private Long bookingId;
	

	@Column
	private LocalDate date;
	
	@Column(name="time_from")
	private LocalTime timeFrom;
	
	@Column(name="time_to")
	private LocalTime timeTo;
	
	@Column
	private Integer seats;
	
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="venue_id")
	private VenueEntity venue;


}
