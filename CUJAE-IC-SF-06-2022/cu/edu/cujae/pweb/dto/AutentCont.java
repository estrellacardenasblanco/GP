package cu.edu.cujae.pweb.dto;

import java.util.ArrayList;




public class AutentCont {
	private int userId;
	private String type;
	private ArrayList<PointDto> intent;
	private Integer passwordId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ArrayList<PointDto> getIntent() {
		return intent;
	}
	public void setIntent(ArrayList<PointDto> intent) {
		this.intent = intent;
	}
	public Integer getPasswordId() {
		return passwordId;
	}
	public void setPasswordId(Integer passwordId) {
		this.passwordId = passwordId;
	}
	public AutentCont(int userId, String type, ArrayList<PointDto> intent, Integer passwordId) {
		super();
		this.userId = userId;
		this.type = type;
		this.intent = intent;
		this.passwordId = passwordId;
	}


	
}
