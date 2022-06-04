package cu.edu.cujae.backend.core.dto;

public class Report2Dto {
	private String description;
	private int cant;
	private int monthNumber;
	private String monthName;
	
	public Report2Dto(String description, int cant, int monthNumber, String monthName) {
		super();
		this.description = description;
		this.cant = cant;
		this.monthNumber = monthNumber;
		this.monthName = monthName;
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
	public int getMonthNumber() {
		return monthNumber;
	}
	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}
	public String getMonthName() {
		return monthName;
	}
	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	
}
