package cu.edu.cujae.pweb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import cu.edu.cujae.pweb.dto.AuthenticationTypeDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;

@Service
public class AuthenticationTypeServiceImpl implements AuthenticationTypeService{

	@Autowired
	private RestService restService;
	@Override
	public List<AuthenticationTypeDto> getAuthenticationTypes() {
		List<AuthenticationTypeDto> authList = new ArrayList<AuthenticationTypeDto>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<AuthenticationTypeDto> apiRestMapper = new ApiRestMapper<>();
		    String response = (String)restService.GET("/api/v1/authenticationtypes", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    authList = apiRestMapper.mapList(response, AuthenticationTypeDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return authList;
	}
	
	@Override
	public AuthenticationTypeDto getAuthenticationTypeById(int id) {
		AuthenticationTypeDto authType = null;
		try {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
			ApiRestMapper<AuthenticationTypeDto> apiRestMapper = new ApiRestMapper<>();
			
			UriTemplate template = new UriTemplate("/api/v1/authenticationtypes/{id}");
		    String uri = template.expand(id).toString();
		    String response = (String)restService.GET(uri, params, String.class).getBody();
		    authType = apiRestMapper.mapOne(response, AuthenticationTypeDto.class);
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		return authType;
	}

}
