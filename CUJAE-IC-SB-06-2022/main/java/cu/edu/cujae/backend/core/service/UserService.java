package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.UserDto;

public interface UserService {
	
	void createUser(UserDto user) throws SQLException;
	
	void updateUser(UserDto user) throws SQLException;
	
	List<UserDto> listUsers() throws SQLException;
	
	UserDto getUserById(int userId) throws SQLException;
	
	UserDto getUserByUsername(String username) throws SQLException;
	
	void deleteUser(int id) throws SQLException;
	
	void updateRegistered(int id) throws SQLException;
}
