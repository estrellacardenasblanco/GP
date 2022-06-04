package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.backend.core.dto.PointDto;
import cu.edu.cujae.backend.core.dto.UserDto;

public interface AuthenticationService {


	void createAuthentication(int userId, int passwordId, ArrayList<PointDto> intent, String type)
			throws SQLException;

	UserDto getUser(String username) throws SQLException;

}
