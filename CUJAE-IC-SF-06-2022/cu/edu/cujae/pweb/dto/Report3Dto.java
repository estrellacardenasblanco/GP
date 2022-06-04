package cu.edu.cujae.pweb.dto;

public class Report3Dto {
	private String username;
	private String imageName;
	private int i;
	public Report3Dto(String username, String imageName, int i) {
		super();
		this.username = username;
		this.imageName = imageName;
		this.i = i;
	}
	public Report3Dto() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

	
	
}
