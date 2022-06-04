package cu.edu.cujae.backend.core.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.Report1Dto;
import cu.edu.cujae.backend.core.dto.Report2Dto;
import cu.edu.cujae.backend.core.dto.Report3Dto;
import cu.edu.cujae.backend.core.dto.Report4Dto;
import cu.edu.cujae.backend.core.dto.Report5Dto;

public interface ReportService {

	List<Report1Dto> report1(Date date) throws SQLException;
	
	List<Report2Dto> report2(String user) throws SQLException;
	
	List<Report3Dto> report3() throws SQLException;
	
	List<Report4Dto> report4(String user) throws SQLException;
	
	List<Report5Dto> report5(String user) throws SQLException;
}
