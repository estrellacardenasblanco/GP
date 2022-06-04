package cu.edu.cujae.backend.core.dto;

import java.sql.Date;

public class Report4Dto {
	private String description;
	private String imageName;
	private int authId;
	private Date date;
	
	public Report4Dto(String description, String imageName, int authId, Date date) {
		super();
		this.description = description;
		this.imageName = imageName;
		this.authId = authId;
		this.date = date;
	}
	
	public Report4Dto() {
		
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

	
}
