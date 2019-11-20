package BrightSkies.Project.FlightTicketSystem.model;


import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;


@Entity
public class FlightTicket implements Serializable
{
	private static final long serialVersionUID = -3679909999869704383L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID ticketNumber = UUID.randomUUID();
	
	private int Fare;
	
	@Column(nullable = false)
	private Flight flight;
	
	@Column(nullable = false)
	private ClassType Type;
	
	@Column(nullable = false)
    private String passengerName;

	
	public UUID getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(UUID ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getFare() {
		return Fare;
	}

	public void setFare(int fare) {
		Fare = fare;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	public ClassType getType() {
		return Type;
	}

	public void setType(ClassType type) {
		Type = type;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
}