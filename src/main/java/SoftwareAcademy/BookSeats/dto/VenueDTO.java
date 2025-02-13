package SoftwareAcademy.BookSeats.dto;

public class VenueDTO {
	private long venueId;
	private String name;
	private String address;
	private Integer availableSeats;
	
	
	public long getVenueId() {
		return venueId;
	}
	
	
	public void setVenueId(long venueId) {
		this.venueId = venueId;
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
	
	
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	
	
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	
}
