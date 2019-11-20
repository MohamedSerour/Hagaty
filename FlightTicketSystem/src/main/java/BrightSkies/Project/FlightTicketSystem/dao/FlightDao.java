package BrightSkies.Project.FlightTicketSystem.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BrightSkies.Project.FlightTicketSystem.model.Flight;

@Repository("FlightDao")
public interface FlightDao extends JpaRepository<Flight,UUID>{
	Flight getByFlightNumber(UUID flightNumber);
	List<Flight> findByDepartureLocation(String departureLocation);
	List<Flight> findByDepartureLocationAndArrivalLocation(String departureLocation, String arrivalLocation);
	List<Flight> findByDepartureLocationAndArrivalLocationAndPrice(String departureLocation, 
			String arrivalLocation,int price);
	

}
