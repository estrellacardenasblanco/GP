package cu.edu.cujae.backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.PictureDto;
import cu.edu.cujae.backend.core.service.PictureService;


@RestController
@RequestMapping("/api/v1/pictures")
public class PictureController {
	
	@Autowired
	private PictureService pictureService;

	
	@GetMapping("")
    public ResponseEntity<List<PictureDto>> getPictures() throws SQLException {
		List<PictureDto> pictureList = pictureService.getPictures();
        return ResponseEntity.ok(pictureList);
    }
	
	@GetMapping("/{name}")
    public ResponseEntity<PictureDto> getPicture(@PathVariable String name) throws SQLException {
		PictureDto picture = pictureService.getPicture(name);
        return ResponseEntity.ok(picture);
    }
	
	@PostMapping("")
    public ResponseEntity<String> create(@RequestBody PictureDto picture) throws SQLException {
		pictureService.createPicture(picture);
        return ResponseEntity.ok("Picture Created");
    }
	
	@PutMapping("")
    public ResponseEntity<String> update(@RequestBody PictureDto picture) throws SQLException {
		pictureService.updatePicture(picture);
        return ResponseEntity.ok("Picture Updated");
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws SQLException {
		pictureService.deletePicture(id);
        return ResponseEntity.ok("Picture deleted");
    }
	
	
	
	
}
