package cu.edu.cujae.pweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.security.CurrentUserUtils;
import cu.edu.cujae.pweb.utils.RestService;
@Service
public class PasswordServiceImpl implements PasswordService{

	@Autowired
	private RestService restService;
	
	@Override
	public void createPassword(UserDto user) {
		restService.POST("/api/v1/passwords", user, String.class, CurrentUserUtils.getTokenBearer()).getBody();
		
	}
}
