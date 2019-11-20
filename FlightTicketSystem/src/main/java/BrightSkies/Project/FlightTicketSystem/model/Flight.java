package BrightSkies.Project.FlightTicketSystem.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Flight implements Serializable 
{
	private static final long serialVersionUID = -3679909999869704383L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private UUID flightNumber;
	
	@Column(nullable = false)
    private String departureLocation;
	
	@Column(nullable = false)
    private String arrivalLocation;
	
	@Column(nullable = false)
    private Date departureTime;
	
	@Column(nullable = false)
    private Date arrivalTime;
	
    private int Price;
	
	public Flight()
	{
		
	}
    public Flight(@JsonProperty("flightNumber")UUID flightNumber,@JsonProperty("depLoc") String departureLocation,
    		@JsonProperty("arrLoc")String arrivalLocation,@JsonProperty("depDate") String departureTime, 
    		@JsonProperty("arrDate")String arrivalTime,@JsonProperty("price") int price) 
    {
		super();
		this.flightNumber = UUID.randomUUID();
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		
    	String depdate = departureTime;
    	String arrdate = arrivalTime;
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm");
    	Date dep = null;
    	Date arr = null;
    	
    	try {
			dep = dateFormat.parse(depdate);
			arr = dateFormat.parse(arrdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		this.departureTime = dep;
		this.arrivalTime = arr;
		this.Price = price;
	}

	public UUID getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(UUID flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
}
