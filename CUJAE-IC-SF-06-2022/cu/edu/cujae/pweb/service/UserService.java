package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.UserDto;

public interface UserService {
	List<UserDto> getUsers();
	UserDto getUserById(int userId);
	void createUser(UserDto user);
	void updateUser(UserDto user);
	void updateRegistered(UserDto user);
	void deleteUser(int id);
	UserDto getUserByName(String username);
}
