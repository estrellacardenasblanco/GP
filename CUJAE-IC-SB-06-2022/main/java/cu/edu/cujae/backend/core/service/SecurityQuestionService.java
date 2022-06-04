package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;

import cu.edu.cujae.backend.core.dto.SecurityQuestionDto;

public interface SecurityQuestionService {

	SecurityQuestionDto getSecurityQuestionById(int id) throws SQLException;
	void createSecurityQuestion(SecurityQuestionDto sq) throws SQLException;

}
