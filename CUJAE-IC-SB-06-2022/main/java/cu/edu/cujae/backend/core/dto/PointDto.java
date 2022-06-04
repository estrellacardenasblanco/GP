package cu.edu.cujae.backend.core.dto;

public class PointDto {

	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public PointDto(int x, int y) {
		this.x = x;
		this.y = y;
	}	
	public PointDto () {
		this.x = 0;
		this.y = 0;
	}
	
}
