package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.AttemptDto;
import cu.edu.cujae.pweb.dto.UserAuthenticatedDto;
import cu.edu.cujae.pweb.security.UserPrincipal;
import cu.edu.cujae.pweb.service.AuthService;
import cu.edu.cujae.pweb.utils.JsfUtils;

@Component
@ManagedBean
@ViewScoped
public class SecurityQuestionBean {
	private int idPregSeg;
	private String question;
	private String answer;
	private List<String> questionList;
	private UserBean userBean;
	
	@Autowired
	private AuthService authService;

	public int getIdPregSeg() {
		return idPregSeg;
	}
	public void setIdPregSeg(int idPregSeg) {
		this.idPregSeg = idPregSeg;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String pregunta) {
		this.question = pregunta;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String respuesta) {
		this.answer = respuesta;
	}
	
	public SecurityQuestionBean( ) {
		questionList = new ArrayList<String>();
		questionList.add("¿Cuál es tu animal favorito?");
		questionList.add("¿Cuál es tu música favorita?");
		questionList.add("¿Cuál es tu cantante favorito?");
	}
	
	public String check() {		
		try {
			userBean = (UserBean)JsfUtils.resolveBean("userBean");
			
			UserAuthenticatedDto userAuthenticated = authService.login(userBean.getUsername(), new AttemptDto(0, question, answer));
			UserDetails userDetails = UserPrincipal.create(userAuthenticated);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        return "success";
		} catch (Exception e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_wrong_data");
			return null;
		}
	}
	public List<String> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	
}
