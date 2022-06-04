package cu.edu.cujae.pweb.bean;

import java.util.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.Report1Dto;
import cu.edu.cujae.pweb.dto.Report2Dto;
import cu.edu.cujae.pweb.dto.Report3Dto;
import cu.edu.cujae.pweb.dto.Report4Dto;
import cu.edu.cujae.pweb.dto.Report5Dto;
import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.service.ReportService;
import cu.edu.cujae.pweb.utils.JsfUtils;

@Component
@ManagedBean
@ViewScoped
public class ManageReportBean {

	private List<Report1Dto> reports1;
	private List<Report3Dto> reports3;
	private List<Report4Dto> reports4;
	private List<Report5Dto> reports5;
	private List<Report2Dto> reports2;
	private UserBean userbean;
	private UserDto user;
	private Date date;
	private String username;
	
	@Autowired
	private ReportService reports;

	public ManageReportBean() 
	{
		
	}

	public List<Report1Dto> getReports1() {
		if(date == null)
			date = new Date (Calendar.getInstance().getTime().getTime());
		try {
			reports1 = reports.report1(new java.sql.Date(date.getTime()));
		} catch (SQLException e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
			e.printStackTrace();
		}
		return reports1;
	}

	public void setReports1(List<Report1Dto> reports1) {
		this.reports1 = reports1;
	}

	public List<Report3Dto> getReports3() {
		try {
			reports3 = reports.report3();
		} catch (SQLException e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
			e.printStackTrace();
		}
		return reports3;
	}

	public void setReports3(List<Report3Dto> reports3) {
		this.reports3 = reports3;
	}

	public ReportService getReports() {
		return reports;
	}

	public void setReports(ReportService reports) {
		this.reports = reports;
	}

	public List<Report4Dto> getReports4() {
		userbean = (UserBean) JsfUtils.resolveBean("userBean");
		user=userbean.getUserDto();
		try {
			reports4 = reports.report4(user.getUsername());
		} catch (SQLException e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
			e.printStackTrace();
		}
		return reports4;
	}

	public void setReports4(List<Report4Dto> reports4) {
		this.reports4 = reports4;
	}

	public List<Report5Dto> getReports5() {
		userbean = (UserBean) JsfUtils.resolveBean("userBean");
		user=userbean.getUserDto();
		try {
			reports5 = reports.report5(user.getUsername());
		} catch (SQLException e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
			e.printStackTrace();
		}
		return reports5;
	}

	public void setReports5(List<Report5Dto> reports5) {
		this.reports5 = reports5;
	}

	public List<Report2Dto> getReports2() {	
		if(username != null && !username.isEmpty())
			try {
				reports2 = reports.report2(username);
			} catch (SQLException e) {
				JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
				e.printStackTrace();
			}
		return reports2;
	}

	public void setReports2(List<Report2Dto> reports2) {
		this.reports2 = reports2;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	



}




