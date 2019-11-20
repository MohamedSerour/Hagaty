package BrightSkies.Project.FlightTicketSystem.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BrightSkies.Project.FlightTicketSystem.model.Users;
import BrightSkies.Project.FlightTicketSystem.service.UserService;

@RestController
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public List<Users> listAll() {
		return userService.listAll();
	}
	
	@PostMapping("/create/user")
	public void createUser(@RequestBody Users user) {
		userService.save(user);
	}
}
