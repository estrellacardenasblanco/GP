package cu.edu.cujae.pweb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import cu.edu.cujae.pweb.dto.PictureDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
@Service
public class PictureServiceImpl implements PictureService{	
	
	@Autowired
	private RestService restService;
	
	@Override
	public List<PictureDto> getPictures() {
		List<PictureDto> pictList = new ArrayList<PictureDto>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<PictureDto> apiRestMapper = new ApiRestMapper<>();
		    String response = (String)restService.GET("/api/v1/pictures", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    pictList = apiRestMapper.mapList(response, PictureDto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pictList;
	}
	@Override
	public void createPicture(PictureDto pict) {
		restService.POST("/api/v1/pictures", pict, String.class, CurrentUserUtils.getTokenBearer()).getBody();
	}
	@Override
	public void updatePicture(PictureDto pict) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		restService.PUT("/api/v1/pictures", params, pict, String.class, CurrentUserUtils.getTokenBearer()).getBody();
	}
	@Override
	public void deletePicture(int id) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		UriTemplate template = new UriTemplate("/api/v1/pictures/{id}");
	    String uri = template.expand(id).toString();
		restService.DELETE(uri, params, String.class,  CurrentUserUtils.getTokenBearer()).getBody();
	}
}
