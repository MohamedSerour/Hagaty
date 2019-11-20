package BrightSkies.Project.FlightTicketSystem.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BrightSkies.Project.FlightTicketSystem.model.FlightTicket;
import BrightSkies.Project.FlightTicketSystem.model.Users;

@Repository("FlightTicketDao")
public interface FlightTicketDao extends JpaRepository<FlightTicket,UUID>
{
	FlightTicket getByTicketNumber(UUID ticketNumber);
	List<FlightTicket> findByPassengerName(Users user);
}
