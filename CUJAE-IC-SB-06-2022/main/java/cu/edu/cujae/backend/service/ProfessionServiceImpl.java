package cu.edu.cujae.backend.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.ProfessionDto;
import cu.edu.cujae.backend.core.service.ProfessionService;




@Service
public class ProfessionServiceImpl implements ProfessionService{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public ProfessionDto getProfession( int profId) throws SQLException {
		ProfessionDto p = null;
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {					
	
			ResultSet result= conn.createStatement().executeQuery("select * from profession where profid='"+profId+"'");
			
			while(result.next()) {
				p = new ProfessionDto(result.getInt("profid"), result.getString("description"));
			}			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return p;
	}
	
	@Override
	public ArrayList<ProfessionDto> getProfessions() throws SQLException {
		ArrayList<ProfessionDto> a = new ArrayList<ProfessionDto>();
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			ResultSet result= conn.createStatement().executeQuery("select * from profession");
			
			while(result.next()) {
				a.add(new ProfessionDto(result.getInt("profid"), result.getString("description")));
			}
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return a;
	}

	@Override
	public ArrayList<String> getProfessionNames() throws SQLException {
		ArrayList<String> a = new ArrayList<String>();
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			ResultSet result= conn.createStatement().executeQuery("select * from profession");
			
			while(result.next()) {
				a.add(result.getString("description"));
			}
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return a;
	}

}
