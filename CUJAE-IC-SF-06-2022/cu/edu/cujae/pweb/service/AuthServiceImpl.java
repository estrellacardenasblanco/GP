package cu.edu.cujae.pweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import cu.edu.cujae.pweb.dto.AttemptDto;
import cu.edu.cujae.pweb.dto.LoginRequestDto;
import cu.edu.cujae.pweb.dto.UserAuthenticatedDto;
import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private RestService restService;

	@Override
	public UserAuthenticatedDto login(String username, AttemptDto password) {
		UserAuthenticatedDto authenticatedDto = null;
		try {
		    ApiRestMapper<UserAuthenticatedDto> apiRestMapper = new ApiRestMapper<>();
		    String response = (String)restService.POST("/api/v1/auth/login", new LoginRequestDto(username, password), String.class).getBody();
		    if(response == null)
		    	throw new Exception("Doubt");
		    authenticatedDto = apiRestMapper.mapOne(response, UserAuthenticatedDto.class);
		} catch (Exception e) {
	    	throw new BadCredentialsException(e.getMessage());
		}
		return authenticatedDto;
	}

	@Override
	public UserDto checkUser(String username) {
		UserDto user = null;

		try {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<UserDto> apiRestMapper = new ApiRestMapper<>();
		    
		    UriTemplate template = new UriTemplate("/api/v1/auth/check/{username}");
		    String uri = template.expand(username).toString();
		    String response = (String)restService.GET(uri, params, String.class).getBody();
		    user = apiRestMapper.mapOne(response, UserDto.class);
		} catch (Exception e) {
			System.out.println("user " + username + " not found");
			//e.printStackTrace();
		}
		return user;
	}
	
}
