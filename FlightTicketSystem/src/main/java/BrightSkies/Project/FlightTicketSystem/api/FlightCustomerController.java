package BrightSkies.Project.FlightTicketSystem.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import BrightSkies.Project.FlightTicketSystem.model.Flight;
import BrightSkies.Project.FlightTicketSystem.service.FlightService;

@RestController
public class FlightCustomerController 
{
	@Autowired
	private FlightService flightService;
	
       @RequestMapping("/search/dep/arr")
	    public List<Flight> searchFlight(@RequestParam("depLoc")String depLoc,
	    		@RequestParam("arrLoc")String arrLoc)
	    {
	    	return flightService.findByDepLocationAndArrLocation(depLoc,arrLoc);
	    }
       
       @RequestMapping("/search/dep")
	    public List<Flight> searchFlightbyDep(@RequestParam("depLoc")String depLoc)
	    {
	    	return flightService.findByDepLocation(depLoc);
	    }
       
       @RequestMapping("/search/dep/arr,price")
	    public List<Flight> searchFlight(@RequestParam("depLoc")String depLoc,
	    		@RequestParam("arrLoc")String arrLoc,
	    		@RequestParam("price")int price)
	    {
	    	return flightService.findByDepLocationAndArrLocationAndPrice(depLoc,arrLoc,price);
	    }
}
