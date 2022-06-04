package cu.edu.cujae.pweb.bean;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.AttemptDto;
import cu.edu.cujae.pweb.dto.AutentCont;
import cu.edu.cujae.pweb.dto.AuthenticationDto;
import cu.edu.cujae.pweb.dto.PasswordDto;
import cu.edu.cujae.pweb.dto.PointDto;
import cu.edu.cujae.pweb.dto.UserAuthenticatedDto;
import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.security.UserPrincipal;
import cu.edu.cujae.pweb.service.AuthService;
import cu.edu.cujae.pweb.utils.FileUtils;
import cu.edu.cujae.pweb.utils.JsfUtils;
import cu.edu.cujae.pweb.utils.SendEmail;

@Component //Le indica a spring es un componete registrado
@ManagedBean
@SessionScoped
public class UserBean{
	
	private UserDto userDto;
	private PasswordDto passwordDto;
	private AuthenticationDto authenticationDto;
	private AutentCont aut;
	
	@Autowired
	private AuthService authService;
	
	
	private String username;
	private String image;
	
	private Integer x;
	private Integer y;
	private ArrayList<PointDto> points;
	private boolean finished;
	private int attempt;
	private int posPassword;
	
	
	
	public UserBean() {
		
	}
	
	@PostConstruct
    public void init() {	    
	    attempt = 1;
	    System.out.println(attempt);
    }
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public AuthenticationDto getAuthenticationDto() {
		return authenticationDto;
	}

	public void setAuthenticationDto(AuthenticationDto authenticationDto) {
		this.authenticationDto = authenticationDto;
	}
	

	public AutentCont getAut() {
		return aut;
	}

	public void setAut(AutentCont aut) {
		this.aut = aut;
	}

	public String checkUsername() {	
		JsfUtils.clearMessages();
		try {
			userDto = authService.checkUser(username);
			
			if(userDto.getPasswords().isEmpty()) {
				UserAuthenticatedDto userAuthenticated = authService.login(username, new AttemptDto());
				UserDetails userDetails = UserPrincipal.create(userAuthenticated);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		        SecurityContextHolder.getContext().setAuthentication(authentication); 
		        return "create";
			}
			
			Double random = Math.random()* (userDto.getPasswords().size() );
			passwordDto = userDto.getPasswords().get(random.intValue());
			posPassword = random.intValue();
			image = passwordDto.getImage().getUrl();
			points = new ArrayList<PointDto>();
			finished = false;
			
			PrimeFaces.current().executeScript("PF('loginBtn').disable()");
			PrimeFaces.current().executeScript("PF('imagePasswordDialog').show()");
			System.out.println("Login attempt " + attempt);
		}catch (java.lang.NullPointerException e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_wrong_user", username);
		}
		return null;
	}
	
	public String login() throws NoSuchAlgorithmException {
		
		if ( attempt < 4 ) {
		try {		
			UserAuthenticatedDto userAuthenticated = authService.login(username, new AttemptDto(0, points));
			UserDetails userDetails = UserPrincipal.create(userAuthenticated);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	        SecurityContextHolder.getContext().setAuthentication(authentication);        
		} catch (Exception e) {
			if(e.getMessage().contentEquals("Doubt")) {
				System.out.println("doubt");
				return "doubt";
			}
			System.out.println("failure");
			//PrimeFaces.current().executeScript("PF('imagePasswordDialog').hide()");
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_wrong_password");
			attempt++;	
			
			String ip = getIp();
			SendEmail.send(userDto.getEmail(),ip, userDto.getPasswords().get(posPassword).getImage().getName());
			
			
			PrimeFaces.current().executeScript("PF('loginBtn').disable()");
			points = new ArrayList<PointDto>();
			finished = false;
			if (attempt == 4) {
				
				JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_too_many_attempts");
				PrimeFaces.current().executeScript("PF('imagePasswordDialog').hide()");
				attempt = 1;
				points = new ArrayList<PointDto>();
				finished = false;
			}
			return null;
		
		}
		System.out.println("success");	
        return "success";
        }
		return null;
	}
	
	public boolean isAdmin() {
		return userDto == null ? false : userDto.getRole().getDescription().contentEquals("administrador");
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	
	public void listener() {
		// Se ejecuta cuando el usuario da clic en la imagen
		System.out.println(x + ", " + y);
		if(!finished)
			points.add(new PointDto(x, y));
		if(points.size()==5) {			
			finished = true;
			PrimeFaces.current().executeScript("PF('loginBtn').enable()");
		}
		
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}


	public void loadImages() {
		Path serverImages = Paths.get(System.getProperty("catalina.base") + "/webapps/images");		
		if(!Files.isDirectory(serverImages)) {
			Path defaultImages = Paths.get(System.getProperty("catalina.base") + 
					"/webapps" + JsfUtils.getRequest().getContextPath() + "/resources/images/default");
			
			FileUtils.copyFolder(defaultImages.toFile(), serverImages.toFile());
			
			System.out.println("images loaded to server!");
		}
	}	
	
	
	public String getIp() {	
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(address.getHostAddress());	  
		return address.getHostAddress();
	}
	
	
}
