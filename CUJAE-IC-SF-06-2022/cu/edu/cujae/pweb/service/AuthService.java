package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.AttemptDto;
import cu.edu.cujae.pweb.dto.UserAuthenticatedDto;
import cu.edu.cujae.pweb.dto.UserDto;

public interface AuthService {
	
	UserAuthenticatedDto login(String username, AttemptDto password);

	UserDto checkUser(String username);
	
}
