package cu.edu.cujae.backend.api.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.Report1Dto;
import cu.edu.cujae.backend.core.dto.Report2Dto;
import cu.edu.cujae.backend.core.dto.Report3Dto;
import cu.edu.cujae.backend.core.dto.Report4Dto;
import cu.edu.cujae.backend.core.dto.Report5Dto;
import cu.edu.cujae.backend.core.service.ReportService;

@RestController
@RequestMapping("/api/v1/reports")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/report1/{date}")
    public ResponseEntity<List<Report1Dto>> getReport1(@PathVariable Date date) throws SQLException {
		List<Report1Dto> report1 = reportService.report1(date);
        return ResponseEntity.ok(report1);
    }
	
	@GetMapping("/report2/{user}")
    public ResponseEntity<List<Report2Dto>> getReport2(@PathVariable String user) throws SQLException {
		List<Report2Dto> report2 = reportService.report2(user);
        return ResponseEntity.ok(report2);
    }
	
	@GetMapping("/report3")
    public ResponseEntity<List<Report3Dto>> getReport3() throws SQLException {
		List<Report3Dto> report3 = reportService.report3();
        return ResponseEntity.ok(report3);
    }
	
	@GetMapping("/report4/{user}")
    public ResponseEntity<List<Report4Dto>> getReport4(@PathVariable String user) throws SQLException {
		List<Report4Dto> report4 = reportService.report4(user);
        return ResponseEntity.ok(report4);
    }
	
	@GetMapping("/report5/{user}")
    public ResponseEntity<List<Report5Dto>> getReport5(@PathVariable String user) throws SQLException {
		List<Report5Dto> report5 = reportService.report5(user);
        return ResponseEntity.ok(report5);
    }
}
