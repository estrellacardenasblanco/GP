package cu.edu.cujae.backend.core.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cu.edu.cujae.backend.core.dto.PasswordDto;
import cu.edu.cujae.backend.core.dto.UserDto;


public class UserPrincipal implements UserDetails {
    private int id;
    private String email;
    private List<PasswordDto> passwords;
    private boolean active;
    private String username;
    private String fullName;
    private String identification;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(int id, String email, List<PasswordDto> passwords, boolean active, String identification, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.setPasswords(passwords);
        this.active = active;
        this.authorities = authorities;
        this.identification = identification;
    }

    public static UserPrincipal create(UserDto user) {
    	List<GrantedAuthority> authorities;
    	try {
    		Collection<String> roleNames = user.getRoles().stream().map(role -> role.getDescription()).collect(Collectors.toList());
    		authorities = AuthorityUtils.createAuthorityList(roleNames.toArray(new String[0]));
		} catch (Exception e) {
			authorities = Collections.
	                singletonList(new SimpleGrantedAuthority("ROLE_USER"));
			
		}
    	return new UserPrincipal(
                user.getUserId(),
                user.getEmail(),
                user.getPasswords(),
                true,
                user.getIdentification(),
                authorities
        );
    }

    public static UserPrincipal create(UserDto user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        return userPrincipal;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return passwords.get(0).getHash();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getFullName() {
        return fullName;
    }

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public List<PasswordDto> getPasswords() {
		return passwords;
	}

	public void setPasswords(List<PasswordDto> passwords) {
		this.passwords = passwords;
	}
}
