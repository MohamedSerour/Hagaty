package BrightSkies.Project.FlightTicketSystem.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import BrightSkies.Project.FlightTicketSystem.dao.FlightDao;
import BrightSkies.Project.FlightTicketSystem.model.Flight;

@Service
public class FlightService 
{
	
	private FlightDao flightRepository;
	
	 @Autowired
	    public FlightService(@Qualifier("FlightDao") FlightDao flightRepository) {
	        this.flightRepository = flightRepository;
	    }
	 
		public List<Flight> listAll()
		{
			return flightRepository.findAll();
		}
		public void save(Flight flight)
		{
			flightRepository.save(flight);
		}
		public Flight get(UUID flightNumber)
		{
			return flightRepository.getByFlightNumber(flightNumber);
		}
		public void delete(UUID ticketNumber)
		{
			flightRepository.deleteById(ticketNumber);
		}
		public boolean existsById(UUID ticketNumber)
		{
			return flightRepository.existsById(ticketNumber);
		}
		
		public List<Flight> findByDepLocationAndArrLocation(String depLoc,String arrLoc)
		{
			return flightRepository.findByDepartureLocationAndArrivalLocation(depLoc,arrLoc);
		}
		public List<Flight> findByDepLocation(String depLoc)
		{
			return flightRepository.findByDepartureLocation(depLoc);
		}
		public List<Flight> findByDepLocationAndArrLocationAndPrice(String depLoc,String arrLoc,int price)
		{
			return flightRepository.findByDepartureLocationAndArrivalLocationAndPrice(depLoc,arrLoc,price);
		}
}
