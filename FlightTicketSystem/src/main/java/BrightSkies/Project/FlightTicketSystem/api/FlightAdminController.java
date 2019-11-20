package BrightSkies.Project.FlightTicketSystem.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import BrightSkies.Project.FlightTicketSystem.model.Flight;
import BrightSkies.Project.FlightTicketSystem.service.FlightService;

@RestController
public class FlightAdminController
{
	@Autowired
	private FlightService flightService;
	
	@RequestMapping("/flights")
    public List<Flight> getAllFlights() //This function to read all the flights in the database
    {
        return flightService.listAll();
    }
	
    @RequestMapping(path="/{flightNumber}")
    public Flight getFlightByFlightNumber(@PathVariable("flightNumber") UUID flightNumber) //This method to read a certain flight by its ID
    {
        return flightService.get(flightNumber);
    }
	
    @PostMapping("/create")
    public void createFlight(@Valid @NotNull @RequestBody Flight flight)
    {
    	flightService.save(flight);
    }
    
    @DeleteMapping(path="/delete/{flightNumber}")
    public void deleteFlightByFlightNumber(@PathVariable("flightNumber") UUID flightNumber)
    {
        flightService.delete(flightNumber);
    }
    

    @PutMapping(path = "/update/{flightNumber}")
    public void UpdateFlight(@PathVariable("flightNumber") UUID flightNumber,@Valid @NotNull @RequestBody Flight flightToBeUpdated)
    {
    	if(flightService.existsById(flightNumber))
    	{
    		flightToBeUpdated.setFlightNumber(flightNumber);
    		flightService.save(flightToBeUpdated);
    	}
    }
}
