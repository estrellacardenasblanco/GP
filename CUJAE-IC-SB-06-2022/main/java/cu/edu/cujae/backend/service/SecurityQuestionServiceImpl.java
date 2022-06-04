package cu.edu.cujae.backend.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.SecurityQuestionDto;
import cu.edu.cujae.backend.core.service.SecurityQuestionService;


@Service
public class SecurityQuestionServiceImpl implements SecurityQuestionService {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private String encodePass(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
	
	@Override
	public SecurityQuestionDto getSecurityQuestionById(int id) throws SQLException {
		SecurityQuestionDto sq= null;
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			ResultSet result= conn.createStatement().executeQuery("select * from securityquestion where questionid='"+id+"'");
			
			while(result.next()) {
				sq = new SecurityQuestionDto(result.getInt("questionid"), result.getString("question"), result.getString("answer"));
			}
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		
		return sq;
	}
	@Override
	public void createSecurityQuestion(SecurityQuestionDto sq) throws SQLException {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {			
			String sql= "{call securityquestion_insert(?,?)}";
			CallableStatement s = conn.prepareCall(sql);		
			s.setString(1,sq.getQuestion());
			s.setString(2,encodePass(sq.getAnswer()));
			s.execute();			
			s.close();
		}catch (Exception e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}finally {
			conn.close();
		}	
	}
}
