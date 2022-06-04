package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.RoleDto;

public interface RoleService {
	List<RoleDto> getRoles();
	RoleDto getRoleById(Integer roleId);
	RoleDto getRoleByDescription(String description);
}
