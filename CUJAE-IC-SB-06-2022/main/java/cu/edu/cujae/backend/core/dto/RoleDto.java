package cu.edu.cujae.backend.core.dto;

public class RoleDto {
	private Integer id;
	private String description;
	
	public RoleDto(Integer id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public RoleDto() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
