package cu.edu.cujae.backend.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.RoleDto;
import cu.edu.cujae.backend.core.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<RoleDto> getRolesByUserId(int userId) throws SQLException {
		List<RoleDto> roleList = new ArrayList<RoleDto>();
		
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(
				      "SELECT roleid, description FROM role join user on user.roleid = role.roleid where user.user_id = ?");
	
			pstmt.setInt(1, userId);
	
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				roleList.add(new RoleDto(rs.getInt("roleid")
						,rs.getString("description")));
			}
		}
		return roleList;
	}

	@Override
	public List<RoleDto> listRoles() throws SQLException {
		List<RoleDto> roleList = new ArrayList<RoleDto>();
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			ResultSet rs = conn.createStatement().executeQuery(
					"SELECT * FROM role");
			
			while(rs.next()){
				roleList.add(new RoleDto(rs.getInt("roleid")
						,rs.getString("description")));
			}
		} 
		return roleList;
	}

	@Override
	public RoleDto getRoleById(int roleId) throws SQLException {
		RoleDto role = null; 
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
		
			PreparedStatement pstmt = conn.prepareStatement(
				      "SELECT * FROM role where roleid = ?");
	
			pstmt.setInt(1, roleId);
	
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				role = new RoleDto(rs.getInt("roleid")
						,rs.getString("description"));
			}
		}
		
		return role;
	}

	@Override
	public RoleDto getRoleByDescription(String description) throws SQLException {
		RoleDto role = null; 
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
		
			PreparedStatement pstmt = conn.prepareStatement(
				      "SELECT * FROM role where description = ?");
	
			pstmt.setString(1, description);
	
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				role = new RoleDto(rs.getInt("roleid")
						,rs.getString("description"));
			}
		}
		
		return role;
	}
}
