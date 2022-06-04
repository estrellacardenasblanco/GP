package cu.edu.cujae.backend.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.AuthenticationTypeDto;
import cu.edu.cujae.backend.core.service.AuthenticationTypeService;


@Service
public class AuthenticationTypeServiceImpl implements AuthenticationTypeService{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public int getTypeId(String type) throws SQLException{
		int id=0;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			ResultSet result= conn.createStatement().executeQuery("select * from type where description='"+type+"'");
			
			while(result.next())
			{
				
				id = result.getInt("typeid");
			}
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return id;
		
	}
	
	@Override
	public ArrayList<AuthenticationTypeDto> getAuthenticationTypes() throws SQLException {
		ArrayList<AuthenticationTypeDto> a = new ArrayList<AuthenticationTypeDto>();
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			ResultSet result= conn.createStatement().executeQuery("select * from type");
			
			while(result.next()) {
				a.add(new AuthenticationTypeDto(result.getInt("typeid"), result.getString("description")));
			}
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return a;
		
	}

	@Override
	public AuthenticationTypeDto getAuthenticationType(Integer id) throws SQLException {
		AuthenticationTypeDto type = null;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			ResultSet result= conn.createStatement().executeQuery("select * from type where typeid='"+id+"'");
			
			while(result.next())
			{				
				type = new AuthenticationTypeDto(result.getInt("typeid"), result.getString("description"));
			}
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return type;
	}
	
	

}
