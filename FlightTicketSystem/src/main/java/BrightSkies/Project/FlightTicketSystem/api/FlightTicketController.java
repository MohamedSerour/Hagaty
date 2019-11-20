package BrightSkies.Project.FlightTicketSystem.api;


import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import BrightSkies.Project.FlightTicketSystem.model.ClassType;
import BrightSkies.Project.FlightTicketSystem.model.Flight;
import BrightSkies.Project.FlightTicketSystem.model.FlightTicket;
import BrightSkies.Project.FlightTicketSystem.service.FlightTicketService;

@RestController
public class FlightTicketController 
{
	@Autowired
	private FlightTicketService flightTicketService;
	
	    
	    @PostMapping("/bookFlight")
		public void bookFlight(@RequestParam("userID") UUID id,@RequestParam("flightNum") UUID Flight) {

	    	if(flightTicketService.getUser(id)!=null)
	    	{
			Flight flight1 = flightTicketService.getFlight(Flight);
			
			
			FlightTicket flightTicket = new FlightTicket();
			
			flightTicket.setPassengerName(flightTicketService.getUser(id).getName());
			flightTicket.setFlight(flight1);
			flightTicket.setType(ClassType.Economy);
			if(flightTicket.getType()== ClassType.Economy)
			{
				flightTicket.setFare(flightTicketService.getFlight(Flight).getPrice());
			}
			else
			{
				flightTicket.setFare((flightTicketService.getFlight(Flight).getPrice())*2);
			}

			flightTicketService.save(flightTicket);
	    	}
		}
	    
	    @DeleteMapping("/cancelFlight")
		public void cancelFlight(@RequestParam("userID") UUID id
				,@RequestParam("ticketNum") UUID ticketNumber)
	    {
	    	if(flightTicketService.getUser(id)!=null && 
	    			flightTicketService.getUser(id).getName().
	    			equalsIgnoreCase(flightTicketService.getTicket(ticketNumber).getPassengerName()))
	    	{
	    		if(flightTicketService.getTicket(ticketNumber)!=null)
	    		{
	    			flightTicketService.delete(ticketNumber);
	    		}
	    		
	    	}	
	    }
	    
	    @PutMapping(path = "/updateTicket")
	    public void UpdateTicket(@RequestParam("userID") UUID id,
	    		@RequestParam("ticketNumber") UUID ticketNumber,
	    		@Valid @NotNull @RequestBody FlightTicket ticketToBeUpdated)
	    {
	    	if(flightTicketService.getUser(id)!=null && 
	    			flightTicketService.getUser(id).getName().
	    			equalsIgnoreCase(flightTicketService.getTicket(ticketNumber).getPassengerName()))
	    	{
	    		if(flightTicketService.getTicket(ticketNumber)!=null)
	    		{
	    			ticketToBeUpdated.setTicketNumber(ticketNumber);
	    			flightTicketService.save(ticketToBeUpdated);
	    		}
	    		
	    	}	
	    }
	
}
