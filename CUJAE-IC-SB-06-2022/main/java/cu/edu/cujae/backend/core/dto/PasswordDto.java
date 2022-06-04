package cu.edu.cujae.backend.core.dto;

import java.util.ArrayList;


public class PasswordDto {

	private ArrayList<PointDto>points; // este arreglo guarda las x y las y cuando se crea la contrasena y los dx y los dy cuando se va a autenticar
	private String hash;	
	private int rT;
	private PictureDto image;
	private SecurityQuestionDto sq;
	private int idpass;
	
	
	public ArrayList<PointDto> getPoints() {
		return points;
	}
	public void setPoints(ArrayList<PointDto> points) {
		this.points = points;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public int getrT() {
		return rT;
	}
	public void setrT(int rT) {
		this.rT = rT;
	}
	public PictureDto getImage() {
		return image;
	}
	public void setImage(PictureDto image) {
		this.image = image;
	}
	public SecurityQuestionDto getSq() {
		return sq;
	}
	public void setSq(SecurityQuestionDto sq) {
		this.sq = sq;
	}
	public int getIdpass() {
		return idpass;
	}
	public void setIdpass(int idpass) {
		this.idpass = idpass;
	}
	public PasswordDto(ArrayList<PointDto> points, String hash, int rT, PictureDto image, SecurityQuestionDto sq,
			int idpass) {
		this.points = points;
		this.hash = hash;
		this.rT = rT;
		this.image = image;
		this.sq = sq;
		this.idpass = idpass;
	}
	public PasswordDto() {
		super();
		this.points = new ArrayList<PointDto>();
	}
	
	
	


	
	
}
