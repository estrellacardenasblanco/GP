package cu.edu.cujae.backend.service;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.PictureDto;
import cu.edu.cujae.backend.core.service.PictureService;


@Service
public class PictureServiceImpl implements PictureService{		
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public ArrayList<PictureDto> getPictures() throws SQLException {
		PictureDto image= null;
		ArrayList<PictureDto> list = new ArrayList<PictureDto>();		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {			
			ResultSet result= conn.createStatement().executeQuery("select * from picture");

			while(result.next()) {
				image = new PictureDto(result.getString("url"),result.getInt("pictureid"), result.getString("name"), result.getDate("date"), result.getString("quality"));
				list.add(image);
			}
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return list;
	}
	
	@Override
	public  void createPicture( PictureDto i) throws SQLException {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
						

			
			String sql= "{call picture_insert(?,?,?,?)}";
			CallableStatement s = conn.prepareCall(sql);		
			s.setString(1,i.getName());
			s.setDate(2,i.getDate());
			s.setString(3,i.getQuality() );
			s.setString(4, i.getUrl());
				
			s.execute();			
			s.close();
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		
	}
/*	@Override
	public void deletePicture( String name) throws SQLException {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			int id = 0;
			
			ResultSet result= conn.createStatement().executeQuery("select * from picture where name='"+name+"'");
			
			while(result.next()) {
				id = result.getInt("pictureid");
			}
						
			String fun = "{call picture_delete(?)}";
			CallableStatement s = conn.prepareCall(fun);
			s.setInt(1, id);
			s.execute();			
			s.close();		
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		
	}*/
 
	@Override
	public void deletePicture( int id) throws SQLException {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {

			String fun = "{call picture_delete(?)}";
			CallableStatement s = conn.prepareCall(fun);
			s.setInt(1, id);
			s.execute();			
			s.close();		
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		
	}
	@Override
	public void updatePicture( PictureDto i) throws SQLException {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {					
			
			String sql= "{call picture_update(?,?,?,?,?)}";
			CallableStatement s = conn.prepareCall(sql);	
			s.setInt(1, i.getId());
			s.setString(2,i.getName());
			s.setDate(3,i.getDate());
			s.setString(4,i.getQuality() );
			s.setString(5, i.getUrl());
				
			s.execute();			
			s.close();			
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		
	}

	@Override
	public PictureDto getPicture(String name) throws SQLException {
		PictureDto p = null;
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {					
	
			ResultSet result= conn.createStatement().executeQuery("select * from picture where name='"+name+"'");
			
			while(result.next()) {
				p = new PictureDto(result.getString("url"),result.getInt("pictureid"), result.getString("name"), result.getDate("date"), result.getString("quality"));
			}			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return p;
	}
}
