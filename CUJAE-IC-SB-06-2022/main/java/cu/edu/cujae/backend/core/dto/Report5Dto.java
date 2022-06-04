package cu.edu.cujae.backend.core.dto;

public class Report5Dto {
	private String imageName;
	private int i;
	public Report5Dto(String imageName, int i) {
		super();
		this.imageName = imageName;
		this.i = i;
	}
	public Report5Dto() {
		
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
