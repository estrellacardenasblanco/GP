package cu.edu.cujae.pweb.dto;

import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


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
	
	private String encodePass(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
	
	public String makeHash() {
		int ix1= (points.get(0).getX()-rT)/(2*rT );
		int iy1=(points.get(0).getY()-rT)/(2*rT );
	    int ix2=(points.get(1).getX()-rT)/(2*rT) ;
	    int iy2=(points.get(1).getY()-rT)/(2*rT) ;
	    int ix3=(points.get(2).getX()-rT)/(2*rT );
	    int iy3=(points.get(2).getY()-rT)/(2*rT );
	    int ix4=(points.get(3).getX()-rT)/(2*rT );
	    int iy4=(points.get(3).getY()-rT)/(2*rT );
	    int ix5=(points.get(4).getX()-rT)/(2*rT) ;
	    int iy5=(points.get(4).getY()-rT)/(2*rT) ;
	    
	    
		String h= new String(ix1+";"+iy1+";"+ix2+";"+iy2+";"+ix3+";"+iy3+";"+ix4+";"+iy4+";"+ix5+";"+iy5);
		return encodePass(h);
	}

	
	
}
