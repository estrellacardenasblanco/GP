package cu.edu.cujae.backend.core.dto;

import java.util.Calendar;

public class DateDto {

	private Calendar dateAuth;
	private int idDate;
	
	public Calendar getDateAuth() {
		return dateAuth;
	}
	public void setDateAuth(Calendar dateAuth) {
		this.dateAuth = dateAuth;
	}
	public int getIdDate() {
		return idDate;
	}
	public void setIdDate(int idDate) {
		this.idDate = idDate;
	}
	public DateDto(Calendar dateAuth, int idDate) {
		super();
		this.dateAuth = dateAuth;
		this.idDate = idDate;
	}
	


}
