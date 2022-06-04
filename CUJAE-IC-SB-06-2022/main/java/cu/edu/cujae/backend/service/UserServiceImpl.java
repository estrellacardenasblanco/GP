package cu.edu.cujae.backend.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.UserDto;
import cu.edu.cujae.backend.core.service.PasswordService;
import cu.edu.cujae.backend.core.service.ProfessionService;
import cu.edu.cujae.backend.core.service.RoleService;
import cu.edu.cujae.backend.core.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private ProfessionService professionService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PasswordService passwordService;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public void createUser(UserDto u) throws SQLException {
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			String sql= "{call user_insert(?,?,?,?,?,?,?,?)}";
			CallableStatement s = conn.prepareCall(sql);		
			s.setString(1,u.getIdentification());
			s.setString(2,u.getGender());
			s.setInt(3, u.getProfession().getId());
			s.setString(4, u.getUsername());
			s.setString(5, u.getFullName());
			s.setInt(6,0);
			s.setInt(7, u.getRole().getId());
			s.setString(8,u.getEmail());
			s.execute();		
			s.close();
			
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
	}


	@Override
	public List<UserDto> listUsers() throws SQLException {
		UserDto u= null;
		ArrayList<UserDto> list = new ArrayList<UserDto>();
		
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			ResultSet result= conn.createStatement().executeQuery("select * from public.user");

			while(result.next()) {
				u = new UserDto(result.getInt("userid"), result.getString("username"),result.getString("fullname"),result.getString("email"),result.getString("identitynumber"), result.getString("gender"), professionService.getProfession(result.getInt("profid")), roleService.getRoleById(result.getInt("roleid")), result.getInt("registered"));
				u.setPasswords(passwordService.getUserPasswords(u.getUserId()));
				list.add(u);
			}
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		return list;
	}
	
	@Override
	public void updateUser(UserDto u) throws SQLException {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
						
			String sql= "{call user_update(?,?,?,?,?,?,?,?,?)}";
			CallableStatement s = conn.prepareCall(sql);		
			s.setString(1,u.getIdentification());
			s.setString(2,u.getGender());
			s.setInt(3, u.getProfession().getId());
			s.setString(4, u.getUsername());
			s.setString(5, u.getFullName());
			s.setInt(6, u.getRegistered());
			s.setInt(7, u.getRole().getId());
			s.setString(8,u.getEmail());
			s.setInt(9,u.getUserId());
			s.execute();			
			s.close();
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}
	}

	@Override
	public UserDto getUserById(int id) throws SQLException {
		
		UserDto u = null;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {			
			
			ResultSet result= conn.createStatement().executeQuery("select * from public.user where userid='"+id+"'");
			
			while(result.next()) {
				u = new UserDto(result.getInt("userid"), result.getString("username"), result.getString("fullname"), result.getString("email"),result.getString("identitynumber"), result.getString("gender"),professionService.getProfession(result.getInt("profid")),
						roleService.getRoleById(result.getInt("roleid")), 
						 result.getInt("registered"));
			}
			
			if(u!= null) {
				u.setPasswords(passwordService.getUserPasswords(u.getUserId()));							
			}
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}			
		
		return u;
	}

	@Override
	public void deleteUser(int id) throws SQLException {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {
			
			String fun = "{call user_delete(?)}";
			CallableStatement s = conn.prepareCall(fun);
			s.setInt(1, id);
			s.execute();			
			s.close();
			
			
		}catch (SQLException exp) {
			exp.printStackTrace();
		}finally {
			conn.close();
		}	
		
	}
	
	

	@Override
	public UserDto getUserByUsername(String username) throws SQLException {
		UserDto u = null;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {			
			
			ResultSet result= conn.createStatement().executeQuery("select * from public.user where username='"+username+"'");
			
			while(result.next()) {
				u = new UserDto(result.getInt("userid"), result.getString("username"), result.getString("fullname"), result.getString("email"),result.getString("identitynumber"), result.getString("gender"),professionService.getProfession(result.getInt("profid")),
						roleService.getRoleById(result.getInt("roleid")), 
						 result.getInt("registered"));
			}
			
			if(u!= null) {
				u.setPasswords(passwordService.getUserPasswords(u.getUserId()));							
			}
			
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}			
		
		return u;
	}
	
	@Override
	public void updateRegistered(int id) throws SQLException {
		Connection conn = jdbcTemplate.getDataSource().getConnection();		
		try {
						
			String sql= "{call user_update_registered(?)}";
			CallableStatement s = conn.prepareCall(sql);		
			s.setInt(1, id);
			s.execute();			
			s.close();
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	
		
	}

}
