package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.backend.core.dto.PictureDto;




public interface PictureService {
	ArrayList<PictureDto> getPictures() throws SQLException;
	void createPicture( PictureDto i) throws SQLException;
	void deletePicture( int id) throws SQLException;
	void updatePicture(PictureDto i) throws SQLException;
	PictureDto getPicture(String name) throws SQLException;
}
