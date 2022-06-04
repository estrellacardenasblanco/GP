package cu.edu.cujae.backend.core.dto;

import org.springframework.lang.NonNull;

public class LoginRequestDto {
	
	@NonNull
    private String username;
	@NonNull
    private AttemptDto password;

	public LoginRequestDto() {
		super();
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
