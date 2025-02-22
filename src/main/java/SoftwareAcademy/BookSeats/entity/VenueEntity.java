package SoftwareAcademy.BookSeats.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="venue")
public class VenueEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="venue_id")
	private Long venueId;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column(name="total_seats")
	private Integer totalSeats;
	
	@Column(name="available_seats")
	private Integer availableSeats;

	@OneToMany(mappedBy="venue",
			cascade = CascadeType.ALL,orphanRemoval = true)
	private List<BookingEntity> bookings;
	
	
	
}
