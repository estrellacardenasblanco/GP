package cu.edu.cujae.backend.api.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.LoginRequestDto;
import cu.edu.cujae.backend.core.dto.UserAuthenticatedDto;
import cu.edu.cujae.backend.core.dto.UserDto;
import cu.edu.cujae.backend.core.security.TokenProvider;
import cu.edu.cujae.backend.core.service.AuthenticationService;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "Authentication endpoint controller")
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
	private AuthenticationService authService;
    
    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequestDto loginRequestDto) {
    	UserDto user;
		try {
			user = authService.getUser(loginRequestDto.getUsername());
		} catch (SQLException e1) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
		}
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);

			String token = tokenProvider.createToken(authentication);
			
			
			UserAuthenticatedDto userAuth = new UserAuthenticatedDto(user.getUserId(), user.getUsername(), user.getFullName(), null, 
					user.getEmail(), user.getIdentification(), user.getRoles(), token);
			
			if(loginRequestDto.getPassword().getPoints() != null)
				authService.createAuthentication(user.getUserId(), user.getPasswords().get(loginRequestDto.getPassword().getPos()).getIdpass(), 
					loginRequestDto.getPassword().getPoints(), "legitimo");
			return ResponseEntity.ok(userAuth);
		} catch (BadCredentialsException | SQLException e) {
			if(loginRequestDto.getPassword().getPoints() != null)
				try {
					authService.createAuthentication(user.getUserId(), user.getPasswords().get(loginRequestDto.getPassword().getPos()).getIdpass(), 
							loginRequestDto.getPassword().getPoints(), e.getMessage().equals("Doubt") ? "dudoso_legitimo" : "ilegitimo");
				} catch (SQLException e1) {
					
				}
			if(e.getMessage().equals("Doubt")) 				
				return ResponseEntity.ok(null);			
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
		}
	}
    
    @GetMapping("/check/{username}")
    public ResponseEntity<UserDto> checkUser(@PathVariable String username) throws SQLException {
		UserDto user = authService.getUser(username);
        return ResponseEntity.ok(user);
    }
    
}
