package cu.edu.cujae.pweb.bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.ProfessionDto;
import cu.edu.cujae.pweb.dto.UserDto;
import cu.edu.cujae.pweb.service.ProfessionService;
import cu.edu.cujae.pweb.service.RoleService;
import cu.edu.cujae.pweb.service.UserService;
import cu.edu.cujae.pweb.utils.JsfUtils;


@Component //Le indica a spring es un componete registrado
@ManagedBean
@ViewScoped //Este es el alcance utilizado para trabajar con Ajax
public class ManageUserBean {
	
	private UserDto selectedUser;
	private List<UserDto> users;
	private Integer professionId;
	
	private List<ProfessionDto> professions;
	
	/* @Autowired es la manera para inyectar una dependencia/clase anotada con @service en spring
	 * Tener en cuenta que lo que se inyecta siempre es la interfaz y no la clase
	 */
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProfessionService professionService;
	
	@Autowired
	private RoleService roleService;	
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ProfessionService getProfessionService() {
		return professionService;
	}

	public void setProfessionService(ProfessionService professionService) {
		this.professionService = professionService;
	}

	public ManageUserBean() {

	}
	
	//Esta anotacioon permite que se ejecute code luego de haberse ejecuta el constructor de la clase. 
	/*@PostConstruct
    public void init() {
	    //users = users == null ? userService.getUsers() : users;
	    //setProfessions(professionService.getProfessions());
    }*/
	
	//Se ejecuta al dar clic en el button Nuevo
	public void openNew() {
        this.selectedUser = new UserDto();
  
   
        
    }
	
	//Se ejecuta al dar clic en el button con el lapicito
	public void openForEdit() {
		this.professionId = this.selectedUser.getProfession().getId();
	}
	
	//Se ejecuta al dar clic en el button dentro del dialog para salvar o registrar al usuario
	public void saveUser() {
		this.selectedUser.setProfession(professionService.getProfessionById(professionId));
        if (this.selectedUser.getUserId() == 0) {          
            this.selectedUser.setRole(roleService.getRoleByDescription("usuario"));
            this.userService.createUser(this.selectedUser);
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_user_added"); //Este code permite mostrar un mensaje exitoso (FacesMessage.SEVERITY_INFO) obteniendo el mensage desde el fichero de recursos, con la llave message_user_added
        }
        else {
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_user_edited");
            this.userService.updateUser(this.selectedUser);
        }        
        
        users=userService.getUsers();

        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
        PrimeFaces.current().ajax().update("form:dt-users");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
    }

	//Permite eliminar un usuario
    public void deleteUser() {
    	try {
    		this.userService.deleteUser(this.selectedUser.getUserId());
            this.selectedUser = null;
            
            users=userService.getUsers();
            
            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_user_deleted");
            PrimeFaces.current().ajax().update("form:dt-users");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
		} catch (Exception e) {
			JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
		}
        
    }

	public UserDto getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserDto selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<UserDto> getUsers() {
		users=userService.getUsers();
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

	public List<ProfessionDto> getProfessions() {
		professions=professionService.getProfessions();
		return professions;
	}

	public void setProfessions(List<ProfessionDto> professions) {
		this.professions = professions;
	}

	public Integer getProfessionId() {
		return professionId;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

}
