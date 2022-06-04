package cu.edu.cujae.backend.api.controller;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.AuthenticationTypeDto;
import cu.edu.cujae.backend.core.service.AuthenticationTypeService;


@RestController
@RequestMapping("/api/v1/authenticationtypes")
public class AuthenticationTypeController {
	@Autowired
	private AuthenticationTypeService typeService;
	
	@GetMapping("")
    public ResponseEntity<List<AuthenticationTypeDto>> getAuthenticationTypes() throws SQLException {
		List<AuthenticationTypeDto> typeList = typeService.getAuthenticationTypes();
        return ResponseEntity.ok(typeList);
    }	
	
	@GetMapping("/{id}")
    public ResponseEntity<AuthenticationTypeDto> getAuthenticationType(@PathVariable Integer id) throws SQLException {
		AuthenticationTypeDto type = typeService.getAuthenticationType(id);
        return ResponseEntity.ok(type);
    }	
	/*
	@GetMapping("/{description}")
	public ResponseEntity<Integer> getTypeId(@PathVariable String description) throws SQLException{
		int id = typeService.getTypeId(description);
		return ResponseEntity.ok(id);
	}
	*/
}