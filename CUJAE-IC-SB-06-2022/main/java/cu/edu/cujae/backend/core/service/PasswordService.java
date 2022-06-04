package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.backend.core.dto.PasswordDto;
import cu.edu.cujae.backend.core.dto.UserDto;

public interface PasswordService {
	void createPassword(UserDto user) throws SQLException;
	void createPassword(PasswordDto password, int userId) throws SQLException;

	ArrayList<PasswordDto> getUserPasswords(int userId) throws SQLException;
	PasswordDto getPassword(int id) throws SQLException;	
}
