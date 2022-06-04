package cu.edu.cujae.backend.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.Report1Dto;
import cu.edu.cujae.backend.core.dto.Report2Dto;
import cu.edu.cujae.backend.core.dto.Report3Dto;
import cu.edu.cujae.backend.core.dto.Report4Dto;
import cu.edu.cujae.backend.core.dto.Report5Dto;
import cu.edu.cujae.backend.core.service.ReportService;


@Service
public class ReportServicelmpl implements ReportService {
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<Report1Dto> report1(Date date) throws SQLException {
		List<Report1Dto> a = new ArrayList<Report1Dto>();
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			ResultSet result= conn.createStatement().executeQuery("select public.type.description , count(authentication.auth_id) as cant\r\n"
					+ "from authentication\r\n"
					+ "join date on authentication.dateid= date.dateid\r\n"
					+ "join public.type on authentication.typeid = public.type.typeid\r\n"
					+ "where date.date =  '"+date+"'\r\n"
					+ "group by public.type.description;");
			while(result.next()) {
				a.add(new Report1Dto(result.getString("description"), result.getInt("cant")));
			}
			result.close();
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return a;
		
	}
	
	@Override
	public List<Report2Dto> report2(String user) throws SQLException {
		List<Report2Dto> a = new ArrayList<Report2Dto>();
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			ResultSet result= conn.createStatement().executeQuery("select count(authentication.userid), public.type.description, \r\n"
					+ "date_part('month',date.date) AS date_month,  get_month(date_part('month',date.date))\r\n"
					+ "from authentication\r\n"
					+ "join date on authentication.dateid= date.dateid\r\n"
					+ "join public.type on authentication.typeid = public.type.typeid\r\n"
					+ "join public.user on authentication.userid= public.user.userid\r\n"
					+ "where public.user.username= '"+user+"'\r\n"
					+ "group by  date_month, public.type.description\r\n"
					+ "order by  date_month;");
			while(result.next()) {
				a.add(new Report2Dto(result.getString("description"), result.getInt("count"), 
						result.getInt("date_month"), result.getString("get_month")));
			}
			result.close();
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return a;
		
	}
	
	@Override
	public List<Report3Dto> report3() throws SQLException {
		List<Report3Dto> a = new ArrayList<Report3Dto>();
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			ResultSet result= conn.createStatement().executeQuery("select picture.name,count(picture.pictureid) as i, public.user.username\r\n"
					+ "from picture \r\n"
					+ "join password on picture.pictureid = password.pictureid \r\n"
					+ "join authentication on password.passid= authentication.passid\r\n"
					+ "join date on authentication.dateid= date.dateid\r\n"
					+ "join public.user on authentication.userid = public.user.userid\r\n"
					+ "join public.type on authentication.typeid = public.type.typeid\r\n"
					+ "where description='dudoso_legitimo'\r\n"
					+ "group by picture.name , public.user.username\r\n"
					+ "order by i desc;");
			
			while(result.next()) {
				a.add(new Report3Dto(result.getString("username"), result.getString("name"), 
						result.getInt("i")));
			}
			
			result.close();
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return a;
		
	}
	
	@Override
	public List<Report4Dto> report4(String user) throws SQLException {
		List<Report4Dto> a = new ArrayList<Report4Dto>();
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			ResultSet result= conn.createStatement().executeQuery("select authentication.auth_id,\r\n"
					+ "picture.name, public.date.date, public.type.description\r\n"
					+ "from authentication\r\n"
					+ "join public.date on authentication.dateid= public.date.dateid\r\n"
					+ "join public.type on authentication.typeid = public.type.typeid\r\n"
					+ "join password on authentication.passid = password.passid\r\n"
					+ "join picture on password.pictureid = picture.pictureid\r\n"
					+ "join public.user on authentication.userid = public.user.userid\r\n"
					+ "where  public.user.username='"+user+"' and public.type.description='ilegitimo'\r\n"
					+ "order by public.date.date;");
			
			while(result.next()) {
				a.add(new Report4Dto(result.getString("description"), result.getString("name"), 
						result.getInt("auth_id"), result.getDate("date")));
			}
			result.close();
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return a;
		
	}
	
	@Override
	public List<Report5Dto> report5(String user) throws SQLException {
		List<Report5Dto> a = new ArrayList<Report5Dto>();
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			ResultSet result= conn.createStatement().executeQuery("select picture.name, count(picture.name) as i\r\n"
					+ "from picture \r\n"
					+ "join password on picture.pictureid = password.pictureid \r\n"
					+ "join authentication on password.passid= authentication.passid\r\n"
					+ "join public.date on authentication.dateid= public.date.dateid\r\n"
					+ "join public.type on authentication.typeid = public.type.typeid\r\n"
					+ "join public.user on authentication.userid = public.user.userid\r\n"
					+ "where description='dudoso_legitimo' and public.user.username='"+user+"'\r\n"
					+ "group by picture.name\r\n"
					+ "order by i desc;");
			
			while(result.next()) {
				a.add(new Report5Dto(result.getString("name"), result.getInt("i")));
			}
			result.close();
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return a;
		
	}
}