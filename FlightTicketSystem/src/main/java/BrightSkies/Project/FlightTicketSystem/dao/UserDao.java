package BrightSkies.Project.FlightTicketSystem.dao;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BrightSkies.Project.FlightTicketSystem.model.Users;

@Repository("UserDao")
public interface UserDao extends JpaRepository<Users,UUID> 
{
	Users getById(UUID id);
	Users getByLogin(String login);
}
