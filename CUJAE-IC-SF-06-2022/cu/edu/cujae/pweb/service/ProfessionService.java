package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.ProfessionDto;

public interface ProfessionService {
	List<ProfessionDto> getProfessions();
	ProfessionDto getProfessionById(Integer professionId);
}
