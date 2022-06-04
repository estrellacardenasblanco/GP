package cu.edu.cujae.backend.core.dto;

public class AuthenticationTypeDto {

	private int id;
	private String description; 

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AuthenticationTypeDto(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	public AuthenticationTypeDto() {
		
	}
	
}
