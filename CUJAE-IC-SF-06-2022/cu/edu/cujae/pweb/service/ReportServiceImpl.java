package cu.edu.cujae.pweb.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import cu.edu.cujae.pweb.dto.Report1Dto;
import cu.edu.cujae.pweb.dto.Report2Dto;
import cu.edu.cujae.pweb.dto.Report3Dto;
import cu.edu.cujae.pweb.dto.Report4Dto;
import cu.edu.cujae.pweb.dto.Report5Dto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;

/* Esta anotiacioon le indica a spring que esta clase es un servicio y por tanto luego podrá inyectarse en otro lugar usando
 * @Autowired. En estas implementaciones luego se pondraan las llamadas al proyecto backend
 */
@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private RestService restService;

	@Override
	public List<Report1Dto> report1(Date date) {
		
		List<Report1Dto> userList = new ArrayList<Report1Dto>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<Report1Dto> apiRestMapper = new ApiRestMapper<>();
		    UriTemplate template = new UriTemplate("/api/v1/reports/report1/{date}");
		    String uri = template.expand(date).toString();
		    String response = (String)restService.GET(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    userList = apiRestMapper.mapList(response, Report1Dto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;

	}

	@Override
	public List<Report2Dto> report2(String user) throws SQLException {
		List<Report2Dto> userList = new ArrayList<Report2Dto>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<Report2Dto> apiRestMapper = new ApiRestMapper<>();
		    UriTemplate template = new UriTemplate("/api/v1/reports/report2/{user}");
		    String uri = template.expand(user).toString();
		    String response = (String)restService.GET(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    userList = apiRestMapper.mapList(response, Report2Dto.class);
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public List<Report3Dto> report3() {
		
		List<Report3Dto> userList = new ArrayList<Report3Dto>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<Report3Dto> apiRestMapper = new ApiRestMapper<>();
		    String response = (String)restService.GET("/api/v1/reports/report3", params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    userList = apiRestMapper.mapList(response, Report3Dto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;

	}

	@Override
	public List<Report4Dto> report4(String user) throws SQLException {
		List<Report4Dto> userList = new ArrayList<Report4Dto>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<Report4Dto> apiRestMapper = new ApiRestMapper<>();
		    UriTemplate template = new UriTemplate("/api/v1/reports/report4/{user}");
		    String uri = template.expand(user).toString();
		    String response = (String)restService.GET(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    userList = apiRestMapper.mapList(response, Report4Dto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public List<Report5Dto> report5(String user) throws SQLException {
		List<Report5Dto> userList = new ArrayList<Report5Dto>();
	    try {
	    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		    ApiRestMapper<Report5Dto> apiRestMapper = new ApiRestMapper<>();
		    UriTemplate template = new UriTemplate("/api/v1/reports/report5/{user}");
		    String uri = template.expand(user).toString();
		    String response = (String)restService.GET(uri, params, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		    userList = apiRestMapper.mapList(response, Report5Dto.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}

	
}
