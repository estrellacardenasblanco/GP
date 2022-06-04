package cu.edu.cujae.pweb.dto;

import java.util.ArrayList;

public class AuthenticationDto {

	private DateDto dateAuth;
	private UserDto user;
	private PasswordDto pass;
	private AuthenticationTypeDto type;
	private ArrayList<PointDto> points;
	private int idAuth;
	
	public DateDto getDateAuth() {
		return dateAuth;
	}
	public void setDateAuth(DateDto dateAuth) {
		this.dateAuth = dateAuth;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public PasswordDto getPass() {
		return pass;
	}
	public void setPass(PasswordDto pass) {
		this.pass = pass;
	}
	public AuthenticationTypeDto getType() {
		return type;
	}
	public void setType(AuthenticationTypeDto type) {
		this.type = type;
	}
	public ArrayList<PointDto> getPoints() {
		return points;
	}
	public void setPoints(ArrayList<PointDto> points) {
		this.points = points;
	}
	public int getIdAuth() {
		return idAuth;
	}
	public void setIdAuth(int idAuth) {
		this.idAuth = idAuth;
	}
	public AuthenticationDto(DateDto dateAuth, UserDto user, PasswordDto pass, AuthenticationTypeDto type,
			ArrayList<PointDto> points, int idAuth) {
		super();
		this.dateAuth = dateAuth;
		this.user = user;
		this.pass = pass;
		this.type = type;
		this.points = points;
		this.idAuth = idAuth;
	}
	

}
