package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.AuthenticationTypeDto;

public interface AuthenticationTypeService {
	List<AuthenticationTypeDto> getAuthenticationTypes();
	AuthenticationTypeDto getAuthenticationTypeById(int id);
}
