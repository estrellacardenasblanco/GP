package cu.edu.cujae.pweb.dto;

public class Report1Dto {
	private String description;
	private int cant;
	public Report1Dto(String description, int cant) {
		super();
		this.description = description;
		this.cant = cant;
	}
	public Report1Dto() {
		super();
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
