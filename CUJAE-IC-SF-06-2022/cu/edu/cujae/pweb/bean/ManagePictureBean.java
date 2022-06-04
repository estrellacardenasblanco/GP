package cu.edu.cujae.pweb.bean;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.PictureDto;
import cu.edu.cujae.pweb.service.PictureService;
import cu.edu.cujae.pweb.utils.JsfUtils;


@Component //Le indica a spring es un componete registrado
@ManagedBean
@ViewScoped //Este es el alcance utilizado para trabajar con Ajax
public class ManagePictureBean {
	
	private PictureDto selectedPicture;	
	private List<PictureDto> pictures;
		
	private Path path;
	
	@Autowired
	private PictureService pictureService;
	
	private UploadedFile imageFile;
	
	public ManagePictureBean() {
		
	}
	
	public UploadedFile getImageFile() {
		return imageFile;
	}

	//Se ejecuta al dar clic en el button Nuevo
	public void openNew() {
        this.selectedPicture = new PictureDto();
        imageFile = null;
    }
	
	public void openForEdit() {
		imageFile = null;
	}
	
	public void savePicture() {
        if (this.selectedPicture.getId() == 0) {
            this.selectedPicture.setUrl(upload());
            this.selectedPicture.calculateQuality(path.toString());
         
            this.selectedPicture.setDate(new Date(new java.util.Date().getTime()));            
            
            this.pictureService.createPicture(this.selectedPicture);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_picture_added");
        }
        else {
        	this.pictureService.updatePicture(this.selectedPicture);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_picture_edited");            
        }
        
        pictures = pictureService.getPictures();

        PrimeFaces.current().executeScript("PF('managePictureDialog').hide()");
        PrimeFaces.current().ajax().update("form:dt-pictures");
    }      
	
	public String upload() {		
		try{			
			Path folder = Paths.get(System.getProperty("catalina.base") + "/webapps/images");
			String extension = FilenameUtils.getExtension(imageFile.getFileName());
			
			Path file = Files.createTempFile(folder, this.selectedPicture.getName() + "-", "." + extension);
			path = file;
			FileOutputStream fos = new FileOutputStream(file.toFile());
			fos.write(imageFile.getContent());			
			
			return "images/" + file.getFileName().toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}		
	}
    
    public void deletePicture() {
    	try {
    		this.pictureService.deletePicture(this.selectedPicture.getId());
            this.selectedPicture = null;
            
            pictures = pictureService.getPictures();
            
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_picture_deleted");
            PrimeFaces.current().ajax().update("form:dt-pictures");
		} catch (Exception e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
		}
        
    }
	

	public PictureDto getSelectedPicture() {
		return selectedPicture;
	}

	public void setSelectedPicture(PictureDto selectedPicture) {
		this.selectedPicture = selectedPicture;
	}

	public List<PictureDto> getPictures() {
		pictures = pictureService.getPictures();
		return pictures;
	}

	public void setPictures(List<PictureDto> pictures) {
		this.pictures = pictures;
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		imageFile = null;
		UploadedFile file = event.getFile();
        if(file != null && file.getContent() != null && file.getContent().length > 0 && file.getFileName() != null)
        	imageFile = file;
	}
	
	public StreamedContent getImage() {
        return DefaultStreamedContent.builder()
            .contentType(imageFile == null ? null : imageFile.getContentType())
            .stream(() -> {
                if (imageFile == null
                        || imageFile.getContent() == null
                        || imageFile.getContent().length == 0) {
                    return null;
                }

                try {
                    return new ByteArrayInputStream(imageFile.getContent());
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            })
            .build();
    }


}