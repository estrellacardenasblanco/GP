package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.PasswordDto;
import cu.edu.cujae.pweb.dto.PictureDto;
import cu.edu.cujae.pweb.dto.PointDto;
import cu.edu.cujae.pweb.dto.SecurityQuestionDto;
import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.service.PasswordService;
import cu.edu.cujae.pweb.service.PictureService;
import cu.edu.cujae.pweb.utils.JsfUtils;
import cu.edu.cujae.pweb.utils.SendEmail;

@Component //Le indica a spring es un componete registrado
@ManagedBean
@ViewScoped //Este es el alcance utilizado para trabajar con Ajax
public class PasswordBean {

	private Integer x;
	private Integer y;
	private PasswordDto password;
	
	private UserBean userbean;
    private UserDto user;
	private int cont = 0;
	
	@Autowired
	PictureService pictureService;
	
	private String src;
	
	private List<PictureDto> images;
	
	@Autowired
	private PasswordService passService;	

	private String question;
	private String answer;

	private int rtol = 10;
	
	public List<PictureDto> getImages() {
		images = pictureService.getPictures();
		
		userbean = (UserBean) JsfUtils.resolveBean("userBean");
		user=userbean.getUserDto();
		
		if(user != null)
		for(int i = 0 ; i < user.getPasswords().size(); i++) {
			for(int k = 0 ; k < images.size(); k++) {
				if (images.get(k).getName().equals(user.getPasswords().get(i).getImage().getName()))
					images.remove(k);
		}
		}
		
		return images;
	}

	public PasswordDto getPassword() {
		return password;
	}

	public void setPassword(PasswordDto password) {
		this.password = password;
	}

	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public void dialogOpened() {
		// Se ejecuta cuando el usuario eligio la imagen y presiona el boton
		password = new PasswordDto(new ArrayList<PointDto>(), "", 20, getImage(), null, 0);
		cont = 0;
		PrimeFaces.current().executeScript("PF('resetBtn').disable()");
		PrimeFaces.current().executeScript("PF('saveBtn').disable()");
	}

	public void listener() {
		// Se ejecuta cuando el usuario da clic en la imagen
		
		if(password == null) {

			PrimeFaces.current().ajax().update("@(form src)");
			password = new PasswordDto(new ArrayList<PointDto>(), "", 20, getImage(), null, 0);
		}		
		PointDto p = new PointDto(x.intValue(), y.intValue());
		
		if (password.getPoints().size() < 5) {
			cont++;
			System.out.println(x + ", " + y);
			password.getPoints().add(p);
			
			
			FacesMessage message = new FacesMessage(JsfUtils.getStringValueFromBundleWithParam("message_point", new Object[]{cont, x, y}));
			//FacesMessage message = new FacesMessage("\"Punto número "+ cont + "\" Eje X: "+x + " Eje Y: "+y);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		else  if (password.getPoints().size() == 5){
			cont=0;
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_points_assigned");
		}
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

	public void savePoints () {
		if (password.getPoints().size() == 5) {
			cont=0;	
			password.setrT(rtol);
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_points_saved");
			PrimeFaces.current().executeScript("PF('imagePasswordDialog').hide()");
			PrimeFaces.current().executeScript("PF('securityQuestionDialog').show()");
		}	
	return;
	}
	
	public void submit() {
		password.setSq(new SecurityQuestionDto(0, question, answer));
		
		userbean = (UserBean) JsfUtils.resolveBean("userBean");
		user=userbean.getUserDto();
		user.getPasswords().add(password);
		passService.createPassword(user);
		
		password.getPoints().clear();
		PrimeFaces.current().executeScript("PF('resetBtn').disable()");
		PrimeFaces.current().executeScript("PF('saveBtn').disable()");
		
		if(user.getPasswords().size() != 5)
		PrimeFaces.current().executeScript("PF('AnotherPassword').show()");
		else 
			PrimeFaces.current().executeScript("PF('AnotherPassword').show()");
		password = null;
	}


	public boolean notHasPoints() {

		boolean rendered = false;

		if(password!= null && password.getPoints().size() == 5)
			rendered = true;

		return !rendered;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public PictureDto getImage() {
		List<PictureDto> array = pictureService.getPictures();
		Iterator<PictureDto> iter = array.iterator();
		while(iter.hasNext()) {
			PictureDto pic = iter.next();
			if(pic.getName().contentEquals(src))
				return pic;
		}
		return null;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public int getRtol() {
		return rtol;
	}

	public void setRtol(int rtol) {
		this.rtol = rtol;
	}
	
	
	public String hasfivepassword () {
		
		String string = "password";
		
		if(user.getPasswords().size() == 5) {
			string = null;
			PrimeFaces.current().executeScript("PF('fivepassword').show()");
		}
		return string;
	}
	
}
