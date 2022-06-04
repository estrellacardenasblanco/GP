package cu.edu.cujae.backend.core.dto;

import java.util.ArrayList;
import java.util.List;


public class UserDto {
	private int userId;
	private String username;
	private String fullName;
	private String email;
	private String identification;
	private String gender;
	private ProfessionDto profession;
	private RoleDto role;
	private List<PasswordDto> passwords;
	private int registered;
	
	public UserDto() {
		super();
	}

	public UserDto(int userId, String username, String fullName, String email, String identification, String gender, ProfessionDto profession, RoleDto role, int registered) {
		this.userId = userId;
		this.username = username;
		this.fullName = fullName;
		this.email = email;
		this.identification = identification;
		this.gender = gender;
		this.profession = profession;
		this.role = role;
		this.registered=registered;
		this.setPasswords(new ArrayList<PasswordDto>());
	}
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ProfessionDto getProfession() {
		return profession;
	}

	public void setProfession(ProfessionDto profession) {
		this.profession = profession;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

	public List<PasswordDto> getPasswords() {
		return passwords;
	}

	public void setPasswords(List<PasswordDto> passwords) {
		this.passwords = passwords;
	}

	public int getRegistered() {
		return registered;
	}

	public void setRegistered(int registered) {
		this.registered = registered;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public List<RoleDto> getRoles() {
		List<RoleDto> roles = new ArrayList<RoleDto>();
		roles.add(role);
		return roles;
	}
}
