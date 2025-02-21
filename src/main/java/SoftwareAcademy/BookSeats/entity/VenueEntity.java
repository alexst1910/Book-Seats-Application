package SoftwareAcademy.BookSeats.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

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

	public Long getVenueId() {
		return venueId;
	}

	public void setVenueId(Long id) {
		this.venueId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	
	
}
