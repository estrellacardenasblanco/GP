package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.PictureDto;


public interface PictureService {
	List<PictureDto> getPictures();
	void createPicture(PictureDto pict);
	void updatePicture(PictureDto pict);
	void deletePicture(int id);
}
