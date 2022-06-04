package cu.edu.cujae.backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.RoleDto;
import cu.edu.cujae.backend.core.service.RoleService;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("")
    public ResponseEntity<List<RoleDto>> getRoles() throws SQLException {
		List<RoleDto> roleList = roleService.listRoles();
        return ResponseEntity.ok(roleList);
    }
	
	@GetMapping("/id/{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable int id) throws SQLException {
		RoleDto role = roleService.getRoleById(id);
        return ResponseEntity.ok(role);
    }
	
	@GetMapping("/{description}")
    public ResponseEntity<RoleDto> getRoleByName(@PathVariable String description) throws SQLException {
		RoleDto role = roleService.getRoleByDescription(description);
        return ResponseEntity.ok(role);
    }
	
	@GetMapping("/users/{userId}")
    public ResponseEntity<List<RoleDto>> getRoleByUserId(@PathVariable int userId) throws SQLException {
		List<RoleDto> roleList = roleService.getRolesByUserId(userId);
        return ResponseEntity.ok(roleList);
    }
	
}
