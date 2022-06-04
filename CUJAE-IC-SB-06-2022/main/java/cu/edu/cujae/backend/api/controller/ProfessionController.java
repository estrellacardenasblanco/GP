package cu.edu.cujae.backend.api.controller;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.ProfessionDto;
import cu.edu.cujae.backend.core.service.ProfessionService;


@RestController
@RequestMapping("/api/v1/professions")
public class ProfessionController {
	@Autowired 
	private ProfessionService profService;
	
	@GetMapping("")
    public ResponseEntity<List<ProfessionDto>> getProfessions() throws SQLException {
		List<ProfessionDto> profList = profService.getProfessions();
        return ResponseEntity.ok(profList);
    }	

	@GetMapping("/id/{id}")
    public ResponseEntity<ProfessionDto> getProfessionById(@PathVariable int id) throws SQLException {
		ProfessionDto profession = profService.getProfession(id);
        return ResponseEntity.ok(profession);
    }
}