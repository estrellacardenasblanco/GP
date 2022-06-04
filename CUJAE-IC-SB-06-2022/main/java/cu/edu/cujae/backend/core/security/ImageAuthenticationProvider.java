package cu.edu.cujae.backend.core.security;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import cu.edu.cujae.backend.core.dto.AttemptDto;
import cu.edu.cujae.backend.core.dto.PasswordDto;
import cu.edu.cujae.backend.core.dto.PointDto;

public class ImageAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	/**
	 * The plaintext password used to perform PasswordEncoder#matches(CharSequence,
	 * String)} on when the user is not found to avoid SEC-2056.
	 */
	private static final String USER_NOT_FOUND_PASSWORD = "userNotFoundPassword";

	private PasswordEncoder passwordEncoder;

	/**
	 * The password used to perform {@link PasswordEncoder#matches(CharSequence, String)}
	 * on when the user is not found to avoid SEC-2056. This is necessary, because some
	 * {@link PasswordEncoder} implementations will short circuit if the password is not
	 * in a valid format.
	 */
	private volatile String userNotFoundEncodedPassword;

	private UserDetailsService userDetailsService;
	

	/*@Autowired
	private AuthenticationService authService;*/
	
	public ImageAuthenticationProvider() {
		setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
	}
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		if (authentication.getCredentials() == null) {
			this.logger.debug("Failed to authenticate since no credentials provided");
			throw new BadCredentialsException(this.messages
					.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
		}
		
		AttemptDto attempt = (AttemptDto)authentication.getCredentials();
		UserPrincipal user = (UserPrincipal)userDetails;
		
		List<PasswordDto> passwords = user.getPasswords();
		ArrayList<PointDto> points = attempt.getPoints();
		
		int pos = attempt.getPos();
		
		if(attempt.getQuestion() != null) {				
			// Security Question check
			if(!passwords.get(pos).getSq().getQuestion().contentEquals(attempt.getQuestion()) || 
					//!passwords.get(pos).getSq().getAnswer().contentEquals(attempt.getAnswer()) ||
					!this.passwordEncoder.matches(attempt.getAnswer(), passwords.get(pos).getSq().getAnswer())) {
				this.logger.debug("Failed to authenticate since question/answer pair does not match stored values.");
				throw new BadCredentialsException("Failure");
			}
		}
		else if(points != null) {		
			// Image Password check
			
			int r = passwords.get(pos).getrT();
			
			int ix1 = (int)  Math.floor(((double)points.get(0).getX()-r)/(2*r)) ;
			int iy1 = (int)  Math.floor(((double)points.get(0).getY()-r)/(2*r)) ;
		    int ix2 = (int)  Math.floor(((double)points.get(1).getX()-r)/(2*r)) ;
		    int iy2 = (int)  Math.floor(((double)points.get(1).getY()-r)/(2*r)) ;
		    int ix3 = (int)  Math.floor(((double)points.get(2).getX()-r)/(2*r)) ;
		    int iy3 = (int)  Math.floor(((double)points.get(2).getY()-r)/(2*r)) ;
		    int ix4 = (int)  Math.floor(((double)points.get(3).getX()-r)/(2*r)) ;
		    int iy4 = (int)  Math.floor(((double)points.get(3).getY()-r)/(2*r)) ;
		    int ix5 = (int)  Math.floor(((double)points.get(4).getX()-r)/(2*r)) ;
		    int iy5 = (int)  Math.floor(((double)points.get(4).getY()-r)/(2*r)) ;
			
		    String h= new String(ix1+";"+iy1+";"+ix2+";"+iy2+";"+ix3+";"+iy3+";"+ix4+";"+iy4+";"+ix5+";"+iy5);
		    
		    if (!this.passwordEncoder.matches(h, passwords.get(pos).getHash())) {
				this.logger.debug("Failed to authenticate since hash code does not match stored value.");
				throw new BadCredentialsException("Failure");
			}
		    
		    int xr1= passwords.get(pos).getPoints().get(0).getX()+ix1*(2*passwords.get(pos).getrT()) + passwords.get(pos).getrT();
			int yr1= passwords.get(pos).getPoints().get(0).getY()+iy1*(2*passwords.get(pos).getrT()) + passwords.get(pos).getrT();
			int xr2=passwords.get(pos).getPoints().get(1).getX()+ix2*(2*passwords.get(pos).getrT()) + passwords.get(pos).getrT();
			int yr2=passwords.get(pos).getPoints().get(1).getY()+iy2*(2*passwords.get(pos).getrT()) + passwords.get(pos).getrT();
			int xr3=passwords.get(pos).getPoints().get(2).getX()+ix3*(2*passwords.get(pos).getrT()) + passwords.get(pos).getrT();
			int yr3=passwords.get(pos).getPoints().get(2).getY()+iy3*(2*passwords.get(pos).getrT()) + passwords.get(pos).getrT();
			int xr4=passwords.get(pos).getPoints().get(3).getX()+ix4*(2*passwords.get(pos).getrT()) + passwords.get(pos).getrT();
			int yr4=passwords.get(pos).getPoints().get(3).getY()+iy4*(2*passwords.get(pos).getrT()) + passwords.get(pos).getrT();
			int xr5=passwords.get(pos).getPoints().get(4).getX()+ix5*(2*passwords.get(pos).getrT()) + passwords.get(pos).getrT();
			int yr5=passwords.get(pos).getPoints().get(4).getY()+iy5*(2*passwords.get(pos).getrT()) + passwords.get(pos).getrT();
			
			double L = 2*(Math.abs(xr1 - points.get(0).getX()) + Math.abs(yr1 - points.get(0).getY()) + 
					Math.abs(xr2 - points.get(1).getX()) + Math.abs(yr2 - points.get(1).getY()) +
					Math.abs(xr3 - points.get(2).getX()) + Math.abs(yr3 - points.get(2).getY()) +
					Math.abs(xr4 - points.get(3).getX()) + Math.abs(yr4 - points.get(3).getY()) +
					Math.abs(xr5 - points.get(4).getX()) + Math.abs(yr5 - points.get(4).getY()))/5 ;
			
			if(L >= passwords.get(pos).getrT()) {
				this.logger.debug("Failed to authenticate. Hash code is correct but average distance (L) is greater than or equal to r. Security question is required.");
				throw new BadCredentialsException("Doubt");
			}		
		}
		
		/*
		 *  If the user is new (i.e. hasn't created any passwords yet), neither a list of 
		 *  points nor a security question are provided. In this case, no checks are performed 
		 *  except for the username check. Next, the frontend application will ask the user
		 *  to create their first password.
		 */
	}
	
	@Override
	protected void doAfterPropertiesSet() {
		Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
	}
	
	@Override
	protected final UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		prepareTimingAttackProtection();
		try {
			UserDetails loadedUser = this.getUserDetailsService().loadUserByUsername(username);
			if (loadedUser == null) {
				throw new InternalAuthenticationServiceException(
						"UserDetailsService returned null, which is an interface contract violation");
			}
			return loadedUser;
		}
		catch (UsernameNotFoundException ex) {
			mitigateAgainstTimingAttack(authentication);
			throw ex;
		}
		catch (InternalAuthenticationServiceException ex) {
			throw ex;
		}
		catch (Exception ex) {
			throw new InternalAuthenticationServiceException(ex.getMessage(), ex);
		}
	}

	private void prepareTimingAttackProtection() {
		if (this.userNotFoundEncodedPassword == null) {
			this.userNotFoundEncodedPassword = this.passwordEncoder.encode(USER_NOT_FOUND_PASSWORD);
		}
	}
	
	private void mitigateAgainstTimingAttack(UsernamePasswordAuthenticationToken authentication) {
		if (authentication.getCredentials() != null) {
			String presentedPassword = ((AttemptDto)authentication.getCredentials()).getH();
			this.passwordEncoder.matches(presentedPassword, this.userNotFoundEncodedPassword);
		}
	}
	
	/**
	 * Sets the PasswordEncoder instance to be used to encode and validate passwords. If
	 * not set, the password will be compared using
	 * {@link PasswordEncoderFactories#createDelegatingPasswordEncoder()}
	 * @param passwordEncoder must be an instance of one of the {@code PasswordEncoder}
	 * types.
	 */
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		Assert.notNull(passwordEncoder, "passwordEncoder cannot be null");
		this.passwordEncoder = passwordEncoder;
		this.userNotFoundEncodedPassword = null;
	}

	protected PasswordEncoder getPasswordEncoder() {
		return this.passwordEncoder;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	protected UserDetailsService getUserDetailsService() {
		return this.userDetailsService;
	}

}
