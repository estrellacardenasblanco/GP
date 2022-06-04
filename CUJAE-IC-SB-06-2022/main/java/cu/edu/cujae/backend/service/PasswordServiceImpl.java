package cu.edu.cujae.backend.service;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.PasswordDto;
import cu.edu.cujae.backend.core.dto.PictureDto;
import cu.edu.cujae.backend.core.dto.PointDto;
import cu.edu.cujae.backend.core.dto.SecurityQuestionDto;
import cu.edu.cujae.backend.core.dto.UserDto;
import cu.edu.cujae.backend.core.service.PasswordService;
import cu.edu.cujae.backend.core.service.SecurityQuestionService;
import cu.edu.cujae.backend.core.service.UserService;



@Service
public class PasswordServiceImpl implements PasswordService{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SecurityQuestionService securityQuestionService;
	
	@Autowired
	private UserService userService;	
	
	private String encodePass(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
	
	@Override
	public void createPassword(UserDto user) throws SQLException {
		int last = user.getPasswords().size()-1;
		createPassword(user.getPasswords().get(last), user.getUserId());		
	}
	
	@Override
	public void createPassword(PasswordDto password, int userId) throws SQLException {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		try {			
			securityQuestionService.createSecurityQuestion(password.getSq());

			ResultSet result2= conn.createStatement().executeQuery("select * from securityquestion order by questionid desc limit 1");			

			while(result2.next())
			{
				password.getSq().setId(result2.getInt("questionid"));
			}

			String sql1= "{call password_insert(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement s1 = conn.prepareCall(sql1);	
			
			List<PointDto> points = password.getPoints();
			int r = password.getrT();

			int ix1 = (int)  Math.floor(((double)points.get(0).getX()-r)/(2*r)) ;
			int iy1 = (int)  Math.floor(((double)points.get(0).getY()-r)/(2*r)) ;
		    int ix2 = (int)  Math.floor(((double)points.get(1).getX()-r)/(2*r)) ;
		    int iy2 = (int)  Math.floor(((double)points.get(1).getY()-r)/(2*r)) ;
		    int ix3 = (int)  Math.floor(((double)points.get(2).getX()-r)/(2*r)) ;
		    int iy3 = (int)  Math.floor(((double)points.get(2).getY()-r)/(2*r)) ;
		    int ix4 = (int)  Math.floor(((double)points.get(3).getX()-r)/(2*r)) ;
		    int iy4 = (int)  Math.floor(((double)points.get(3).getY()-r)/(2*r)) ;
		    int ix5 = (int)  Math.floor(((double)points.get(4).getX()-r)/(2*r)) ;
		    int iy5 = (int)  Math.floor(((double)points.get(4).getY()-r)/(2*r)) ;

			int dx1= (points.get(0).getX()-r)%(2*r) ;
			int dy1= (points.get(0).getY()-r)%(2*r);
			int dx2=(points.get(1).getX()-r)%(2*r);
			int dy2=(points.get(1).getY()-r)%(2*r);
			int dx3=(points.get(2).getX()-r)%(2*r) ;
			int dy3=(points.get(2).getY()-r)%(2*r );
			int dx4=(points.get(3).getX()-r)%(2*r );
			int dy4=(points.get(3).getY()-r)%(2*r );
			int dx5=(points.get(4).getX()-r)%(2*r );
			int dy5=(points.get(4).getY()-r)%(2*r) ;
			
			String h= new String(ix1+";"+iy1+";"+ix2+";"+iy2+";"+ix3+";"+iy3+";"+ix4+";"+iy4+";"+ix5+";"+iy5);
			//MessageDigest hash = MessageDigest.getInstance("SHA-256");
			String hashi = encodePass(h);//bytesToHex(hash.digest(h.getBytes()));
			
			
			/*System.out.println("h:");
			System.out.println(h);
			System.out.println("Hashi:");
			System.out.println(hashi);
			System.out.println("dxdy 1");
			System.out.println(dx1);
			System.out.println(dy1);
			System.out.println("dxdy 2");
			System.out.println(dx2);
			System.out.println(dy2);
			System.out.println("dxdy 3");
			System.out.println(dx3);
			System.out.println(dy3);
			System.out.println("dxdy 4");
			System.out.println(dx4);
			System.out.println(dy4);
			System.out.println("dxdy 5");
			System.out.println(dx5);
			System.out.println(dy5);*/
			
			s1.setInt(1,password.getImage().getId());
			s1.setInt(2,password.getrT());
			s1.setInt(3, password.getSq().getId());
			s1.setString(4,hashi);
			s1.setInt(5,dx1);
			s1.setInt(6,dy1);
			s1.setInt(7,dx2);
			s1.setInt(8,dy2);
			s1.setInt(9,dx3);
			s1.setInt(10,dy3);
			s1.setInt(11,dx4);
			s1.setInt(12,dy4);
			s1.setInt(13,dx5);
			s1.setInt(14,dy5);

			s1.execute();			
			s1.close();




			ResultSet result4= conn.createStatement().executeQuery("select * from password order by passid desc limit 1");			
			int idcont= 0;
			while(result4.next()) {
				idcont = result4.getInt("passid");	
			}
			result4.close();
			
			String sql2= "{call user_password_insert(?,?)}";
			CallableStatement s2 = conn.prepareCall(sql2);		
			s2.setInt(1,idcont);
			s2.setInt(2,userId);		
			s2.execute();			
			s2.close();
			
			userService.updateRegistered(userId);
		}catch (Exception exp) {
			exp.printStackTrace();
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}	

	}
	
	@Override
	public ArrayList<PasswordDto> getUserPasswords(int userId) throws SQLException {
		ArrayList<PasswordDto> list = new ArrayList<PasswordDto>();
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		
		try {	
			ResultSet result2= conn.createStatement().executeQuery("select * from password "
					+ "join user_password on password.passid= user_password.passid "
					+ "where user_password.userid='"+userId+"'");

			while (result2.next()) {


				String hashi= result2.getString("ihash");

				PointDto p1= new PointDto(result2.getInt("x1"),result2.getInt("y1") );
				PointDto p2=  new PointDto(result2.getInt("x2"),result2.getInt("y2") );
				PointDto p3=  new PointDto(result2.getInt("x3"),result2.getInt("y3") );
				PointDto p4=  new PointDto(result2.getInt("x4"),result2.getInt("y4") );
				PointDto p5=  new PointDto(result2.getInt("x5"),result2.getInt("y5") );
				ArrayList<PointDto> points= new ArrayList<PointDto>();
				points.add(p1);
				points.add(p2);
				points.add(p3);
				points.add(p4);
				points.add(p5);
				PictureDto i = new PictureDto("/Images/", result2.getInt("pictureid"), "", null, "");
				PasswordDto cont = new PasswordDto(points,hashi,result2.getInt("radius"),i, new SecurityQuestionDto(result2.getInt("questionid")),result2.getInt("passid"));

				list.add(cont);

			}				

			ResultSet result4= conn.createStatement().executeQuery("select * from securityquestion");
			while (result4.next()) {
				for (int i = 0; i < list.size(); i++) {
					if(result4.getInt("questionid")==list.get(i).getSq().getId()) {
						list.get(i).getSq().setQuestion(result4.getString("question"));
						list.get(i).getSq().setAnswer(result4.getString("answer"));
					}
				}
			}		

			ResultSet result3= conn.createStatement().executeQuery("select * from picture ");

			while (result3.next()) {
				// hay que ver como es la direccion de la imagen
				for (int i= 0 ; i < list.size(); i++) {
					if (result3.getInt("pictureid")== list.get(i).getImage().getId()) {
						list.get(i).getImage().setName(result3.getString("name"));
						list.get(i).getImage().setUrl(result3.getString("url"));
						list.get(i).getImage().setQuality(result3.getString("quality"));
					}
				}
			}				
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}
		return list;
	}

	@Override
	public PasswordDto getPassword(int id) throws SQLException {
		PasswordDto password = null;
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		
		try {	
			ResultSet result= conn.createStatement().executeQuery("select * from password where passid='"+id+"'");

			while (result.next()) {
				String hashi= result.getString("ihash");

				PointDto p1= new PointDto(result.getInt("x1"),result.getInt("y1") );
				PointDto p2=  new PointDto(result.getInt("x2"),result.getInt("y2") );
				PointDto p3=  new PointDto(result.getInt("x3"),result.getInt("y3") );
				PointDto p4=  new PointDto(result.getInt("x4"),result.getInt("y4") );
				PointDto p5=  new PointDto(result.getInt("x5"),result.getInt("y5") );
				ArrayList<PointDto> points= new ArrayList<PointDto>();
				points.add(p1);
				points.add(p2);
				points.add(p3);
				points.add(p4);
				points.add(p5);				
				PictureDto i = new PictureDto("/Images/", result.getInt("pictureid"), "", null, "");
				password = new PasswordDto(points,hashi,result.getInt("radius"),i, new SecurityQuestionDto(result.getInt("questionid")),result.getInt("passid"));
			}				

			ResultSet result2= conn.createStatement().executeQuery("select * from securityquestion where questionid='"+password.getSq().getId()+"'");
			while (result2.next()) {
				password.getSq().setQuestion(result2.getString("question"));
				password.getSq().setAnswer(result2.getString("answer"));

			}		

			ResultSet result3= conn.createStatement().executeQuery("select * from picture where pictureid='"+password.getImage().getId()+"'");
			while (result3.next()) {
				password.getImage().setName(result3.getString("name"));
				password.getImage().setUrl(result3.getString("url"));
				password.getImage().setQuality(result3.getString("quality"));
			}				
		}catch (SQLException exp) {
			throw new SQLException(exp.getMessage());
		}finally {
			conn.close();
		}
		return password;
	}
}
