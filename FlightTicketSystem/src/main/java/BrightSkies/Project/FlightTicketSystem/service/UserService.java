package BrightSkies.Project.FlightTicketSystem.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import BrightSkies.Project.FlightTicketSystem.dao.UserDao;
import BrightSkies.Project.FlightTicketSystem.model.Users;

@Service
public class UserService 
{
	private UserDao userDao;
	
	@Autowired
	 public UserService(@Qualifier("UserDao") UserDao userDao)
	 {
	      this.userDao = userDao;
	 }


	public void save(Users user)
	{
		userDao.save(user);
	}
	
	public Users getById(UUID id)
	{
		return userDao.getById(id);
	}
	
	public Users getByLogin(String login)
	{
		return userDao.getByLogin(login);
	}
	public List<Users> listAll()
	{
		return userDao.findAll();
	}
}		 

