package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.ArrayList;


import cu.edu.cujae.backend.core.dto.ProfessionDto;




public interface ProfessionService {
	 ProfessionDto getProfession(int profId) throws SQLException ;
	 ArrayList<ProfessionDto> getProfessions() throws SQLException;
	 ArrayList<String> getProfessionNames() throws SQLException;
}
