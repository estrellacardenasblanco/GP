package cu.edu.cujae.backend.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.PasswordDto;
import cu.edu.cujae.backend.core.dto.PointDto;
import cu.edu.cujae.backend.core.dto.UserDto;
import cu.edu.cujae.backend.core.service.AuthenticationService;
import cu.edu.cujae.backend.core.service.AuthenticationTypeService;
import cu.edu.cujae.backend.core.service.DateService;
import cu.edu.cujae.backend.core.service.PasswordService;
import cu.edu.cujae.backend.core.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	private DateService dateService;
	@Autowired
	private PasswordService passService;	
	@Autowired
	private AuthenticationTypeService authtypeService;
	@Autowired
	private UserService userService;

	
	public static double calculateL(ArrayList<PointDto>intent, PasswordDto password, int r) {
		double L=0, L1 = 0;
		
		double L1max = 5*(Math.log10(1/(double)r)*3.32); // valor de L de la contrasena mas probable
		
		for (int i = 0; i < intent.size(); i++) {
			if (password.getPoints().get(i).getX()-r<=intent.get(i).getX() && 
				password.getPoints().get(i).getX()+r>=intent.get(i).getX() && 
				password.getPoints().get(i).getY()-r<=intent.get(i).getY() && 
				password.getPoints().get(i).getY()+r>=intent.get(i).getY()) {
					L1+=(Math.log10(1/(double)r)*3.32);
			}
		}
		
		// Lmin es 0 porque es la menos probable
		
		L = (L1max - L1)/L1max;
		
		return Math.abs(L);
	}	

	
	public void createAuthentication(int userId, int passwordId, ArrayList<PointDto> intent, String type) throws SQLException {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			int dateId = dateService.createDate();
			int typeId = authtypeService.getTypeId(type);
			
			PasswordDto password = passService.getPassword(passwordId);
												
			String sql= "{call authentication_insert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement s = conn.prepareCall(sql);		
			s.setInt(1,userId);
			s.setInt(2,password.getIdpass());
			s.setInt(3, dateId);
			s.setInt(4, typeId);
			s.setInt(5, intent.get(0).getX());	
			s.setInt(6, intent.get(0).getY());
			s.setInt(7, intent.get(1).getX());
			s.setInt(8, intent.get(1).getY());
			s.setInt(9, intent.get(2).getX());
			s.setInt(10, intent.get(2).getY());
			s.setInt(11, intent.get(3).getX());
			s.setInt(12, intent.get(3).getY());
			s.setInt(13, intent.get(4).getX());
			s.setInt(14, intent.get(4).getY());
			s.setDouble(15, calculateL(intent, password, password.getrT()));
			s.execute();			
			s.close();
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		
	}


	@Override
	public UserDto getUser(String username) throws SQLException {
		UserDto u = userService.getUserByUsername(username);
		for (PasswordDto password : u.getPasswords()) {
			password.setHash(null);
			password.setPoints(null);
			password.setSq(null);
		}		
		return u;
	}

}
