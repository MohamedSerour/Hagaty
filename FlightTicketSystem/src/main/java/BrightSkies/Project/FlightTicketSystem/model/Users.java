package BrightSkies.Project.FlightTicketSystem.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Users implements Serializable {
	
	private static final long serialVersionUID = -3679909999869704383L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
    private UUID id;
	
	@Column(nullable = false)
	private String login;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Role role;
	
	@Column(nullable = false)
	private String Name;

	public Users()
	{
		
	}
	
	 public Users(@JsonProperty("login") String login,
	    		@JsonProperty("password")String password,@JsonProperty("role") Role role, 
	    		@JsonProperty("name")String Name)
	    		{
		 			super();
		 			this.id = UUID.randomUUID();
		 			this.login = login;
		 			this.password = password;
		 			this.role = role;
		 			this.Name = Name;
	    		}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
