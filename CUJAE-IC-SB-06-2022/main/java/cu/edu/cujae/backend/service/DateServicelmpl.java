package cu.edu.cujae.backend.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.service.DateService;




@Service
public class DateServicelmpl implements DateService {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public int createDate() throws SQLException {
		Date date = new Date (Calendar.getInstance().getTime().getTime());
		int id=0;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			/*Statement statement= con.getCon().createStatement();
						
			statement.executeQuery("select fecha_insert('"+fecha.toString()+"')");

			statement.close();*/
			
			String sql= "{call date_insert(?)}";
			CallableStatement s = conn.prepareCall(sql);		
			s.setDate(1,date);						
			s.execute();			
			s.close();
						
			
			ResultSet result= conn.createStatement().executeQuery("select * from date order by dateid desc limit 1");
			
			while(result.next())
			{				
				id = result.getInt("dateid");
			}
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return id;
		
	}




}
