package cu.edu.cujae.pweb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;

/* Esta anotiacioon le indica a spring que esta clase es un servicio y por tanto luego podrá inyectarse en otro lugar usando
 * @Autowired. En estas implementaciones luego se pondraan las llamadas al proyecto backend
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private RestService restService;

	@Override
	public List<UserDto> getUsers() {
		
		List<UserDto> userList = new ArrayList<UserDto>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<UserDto> apiRestMapper = new ApiRestMapper<>();
		    String response = (String)restService.GET("/api/v1/users", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    userList = apiRestMapper.mapList(response, UserDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;

	}
	@Override
	public UserDto getUserByName(String username) {
		UserDto user = null;

		try {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<UserDto> apiRestMapper = new ApiRestMapper<>();
		    
		    UriTemplate template = new UriTemplate("/api/v1/users/{username}");
		    String uri = template.expand(username).toString();
		    String response = (String)restService.GET(uri, params, String.class).getBody();
		    user = apiRestMapper.mapOne(response, UserDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
		
	@Override
	public UserDto getUserById(int id) {
		UserDto user = null;

		try {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<UserDto> apiRestMapper = new ApiRestMapper<>();
		    
		    UriTemplate template = new UriTemplate("/api/v1/users/id/{id}");
		    String uri = template.expand(id).toString();
		    String response = (String)restService.GET(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    user = apiRestMapper.mapOne(response, UserDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void createUser(UserDto user) {
		restService.POST("/api/v1/users", user, String.class, CurrentUserUtils.getTokenBearer()).getBody();
	}

	@Override
	public void updateUser(UserDto user) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		restService.PUT("/api/v1/users", params, user, String.class, CurrentUserUtils.getTokenBearer()).getBody();
	}
	@Override
	public void updateRegistered(UserDto user) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		restService.PUT("/api/v1/users/registered/{id}", params, user.getUserId(), String.class, CurrentUserUtils.getTokenBearer()).getBody();
	}

	@Override
	public void deleteUser(int id) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		UriTemplate template = new UriTemplate("/api/v1/users/{id}");
	    String uri = template.expand(id).toString();
		restService.DELETE(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
	}
	
}
