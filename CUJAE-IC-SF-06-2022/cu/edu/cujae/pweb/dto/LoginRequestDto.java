package cu.edu.cujae.pweb.dto;


public class LoginRequestDto {
	
    private String username;
    private AttemptDto password;
    
    public LoginRequestDto(String username, AttemptDto password) {
		super();
		this.username = username;
		this.password = password;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AttemptDto getPassword() {
		return password;
	}

	public void setPassword(AttemptDto password) {
		this.password = password;
	}

}
