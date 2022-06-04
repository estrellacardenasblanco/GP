package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.backend.core.dto.AuthenticationTypeDto;

public interface AuthenticationTypeService {

	int getTypeId(String type) throws SQLException;

	ArrayList<AuthenticationTypeDto> getAuthenticationTypes() throws SQLException;

	AuthenticationTypeDto getAuthenticationType(Integer id) throws SQLException;
}
