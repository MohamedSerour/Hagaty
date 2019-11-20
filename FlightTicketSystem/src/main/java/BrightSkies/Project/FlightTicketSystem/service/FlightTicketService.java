package BrightSkies.Project.FlightTicketSystem.service;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;





import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import BrightSkies.Project.FlightTicketSystem.dao.FlightDao;
import BrightSkies.Project.FlightTicketSystem.dao.FlightTicketDao;
import BrightSkies.Project.FlightTicketSystem.dao.UserDao;
import BrightSkies.Project.FlightTicketSystem.model.Flight;
import BrightSkies.Project.FlightTicketSystem.model.FlightTicket;
import BrightSkies.Project.FlightTicketSystem.model.Users;

@Service
public class FlightTicketService
{
	private FlightDao flightDao;

	private FlightTicketDao flightTicketDao;
	
	private UserDao userDao;
	
	 @Autowired
	    public FlightTicketService(@Qualifier("FlightDao") FlightDao flightDao,
	    		@Qualifier("FlightTicketDao") FlightTicketDao flightTicketDao,
	    		@Qualifier("UserDao") UserDao userDao) {
	        this.flightDao = flightDao;
	        this.flightTicketDao = flightTicketDao;
	        this.userDao = userDao;
	    }
	
	public boolean existsById(UUID ticketNumber)
	{
		return flightTicketDao.existsById(ticketNumber);
	}

	public Flight getFlight(UUID flightNumber) {
		// TODO Auto-generated method stub
		return flightDao.getByFlightNumber(flightNumber);
	}
	
	public FlightTicket getTicket(UUID ticketNumber) {
		// TODO Auto-generated method stub
		return flightTicketDao.getByTicketNumber(ticketNumber);
	}

	public void save(FlightTicket ticketToBeUpdated) {
		// TODO Auto-generated method stub
		flightTicketDao.save(ticketToBeUpdated);
	}
	
	public Users getUser(UUID id) {
		// TODO Auto-generated method stub
		return userDao.getById(id);
	}
	
	public void delete(UUID ticketNumber)
	{
		flightTicketDao.deleteById(ticketNumber);
	}
}
