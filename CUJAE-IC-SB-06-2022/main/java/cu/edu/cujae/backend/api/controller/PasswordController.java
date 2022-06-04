package cu.edu.cujae.backend.api.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.PasswordDto;
import cu.edu.cujae.backend.core.dto.UserDto;
import cu.edu.cujae.backend.core.service.PasswordService;

@RestController
@RequestMapping("/api/v1/passwords")
public class PasswordController {
	@Autowired 
	private PasswordService passService;

	@PostMapping("")
    public ResponseEntity<String> create(@RequestBody UserDto user) throws Exception {
		passService.createPassword(user);
		//passService.createPassword(password, userId);
        return ResponseEntity.ok("Password Created");
    }
	
	@PostMapping("/{userId}")
    public ResponseEntity<String> create(@RequestBody PasswordDto password, @PathVariable int userId) throws Exception {
		//passService.createPassword(user);
		passService.createPassword(password, userId);
        return ResponseEntity.ok("Password Created");
    }


}