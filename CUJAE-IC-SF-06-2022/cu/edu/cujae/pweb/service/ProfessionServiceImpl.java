package cu.edu.cujae.pweb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import cu.edu.cujae.pweb.dto.ProfessionDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;

@Service
public class ProfessionServiceImpl implements ProfessionService{

	@Autowired
	private RestService restService;
	
	@Override
	public List<ProfessionDto> getProfessions() {
		List<ProfessionDto> profList = new ArrayList<ProfessionDto>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<ProfessionDto> apiRestMapper = new ApiRestMapper<>();
		    String response = (String)restService.GET("/api/v1/professions", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    profList = apiRestMapper.mapList(response, ProfessionDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return profList;
	}

	@Override
	public ProfessionDto getProfessionById(Integer professionId) {
		ProfessionDto profession = null;

		try {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<ProfessionDto> apiRestMapper = new ApiRestMapper<>();
		    
		    UriTemplate template = new UriTemplate("/api/v1/professions/id/{id}");
		    String uri = template.expand(professionId).toString();
		    String response = (String)restService.GET(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    profession = apiRestMapper.mapOne(response, ProfessionDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profession;
	}

}
