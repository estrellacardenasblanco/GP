package cu.edu.cujae.backend.core.dto;

public class Report1Dto {
	private String description;
	private int cant;
	public Report1Dto(String description, int cant) {
		super();
		this.description = description;
		this.cant = cant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	
	
}
