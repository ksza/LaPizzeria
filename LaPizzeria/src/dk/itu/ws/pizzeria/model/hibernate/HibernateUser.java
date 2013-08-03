package dk.itu.ws.pizzeria.model.hibernate;

import java.util.Hashtable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import dk.itu.ws.pizzeria.model.User;
import dk.itu.ws.pizzeria.model.dao.hibernate.HibernateDAOFactory;

@Entity
@Table(name = "users", schema = "lapizzeria")
public class HibernateUser extends User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return super.getId();
	}

	@Column(name = "email", nullable = false, unique = true)
	public String getEmail() {
		return super.getEmail();
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return super.getPassword();
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return super.getName();
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return super.getAddress();
	}

	@Column(name = "zip", nullable = false)
	public String getZipCode() {
		return super.getZipCode();
	}

	@Column(name = "phone", nullable = true)
	public String getPhoneNo() {
		return super.getPhoneNo();
	}
	
//	@Column(name = "valid", nullable = false)
//	public Boolean getValid() {
//		return super.getValid();
//	}
	
	/* ***************** utility methods **************** */
	@Transient
	private Hashtable<String, String> errors = new Hashtable<String, String>();

	public boolean validate() {
		boolean valid = true;
		
		errors.clear();
		
		if(super.getName() == null || super.getName().equals("")) {
			errors.put("name", "Please enter your name");
			super.setName("");
			valid = false;
		}
		
		if(super.getAddress() == null || super.getAddress().equals("")) {
			errors.put("address", "You must provide an address");
			super.setAddress("");
			valid = false;
		}
		
		if(super.getEmail() == null || super.getEmail().equals("") || (super.getEmail().indexOf('@') == -1)) {
			errors.put("email", "Please enter a valid email address");
			super.setEmail("");
			valid = false;
		} 
		else {
			List<User> result = HibernateDAOFactory.getInstance().getUserDAO().findByEmail(super.getEmail());
			if(result != null && result.size() > 0) {
				errors.put("email", "A user with this email already exists!");
				valid = false;
			}
		}
		
		if(super.getPassword() != null && ! super.getPassword().equals("")) {
			
			int digits = 0, letters = 0, nonAlphaNumeric = 0;
			
			for(int i = 0; i < super.getPassword().length(); i++) {
				if(Character.isDigit(super.getPassword().charAt(i))) {
					digits++;
				}
				
				if(Character.isLetter(super.getPassword().charAt(i))) {
					letters++;
				}
				
				if(! Character.isLetterOrDigit(super.getPassword().charAt(i))) {
					nonAlphaNumeric++;
				}
			}
			
			if(digits == 0 || letters == 0 || nonAlphaNumeric == 0) {
				errors.put("password", "Should contain at least six characters, at least one digit, at least one letter character, and at least one non-digit/letter-character");
				super.setPassword("");
				valid = false;
			}
		} else {			
			errors.put("password", "Please enter a password");
			super.setPassword("");
			valid = false;
		}
		
		if(super.getZipCode() == null || super.getZipCode().equals("") || super.getZipCode().length() != 4 ) {
			errors.put("zipCode","Please enter a valid, four digit zip code");
			super.setZipCode("");
			valid = false;
		} else {
			try {
				Integer.parseInt(super.getZipCode());
			} catch (NumberFormatException e) {
				errors.put("zipCode","Please enter a valid, four digit zip code");
				super.setZipCode("");
				valid = false;
			}
		}
		
		if(super.getPhoneNo() == null || super.getPhoneNo().equals("") || super.getPhoneNo().length() != 8 ) {
			errors.put("phoneNo","Please enter a valid, eight digit phone number");
			super.setPhoneNo("");
			valid = false;
		} else {
			try {
				Integer.parseInt(super.getPhoneNo());
			} catch (NumberFormatException e) {
				errors.put("phoneNo","Please enter a valid, eight digit phone number");
				super.setPhoneNo("");
				valid = false;
			}
		}
		
		return valid;
	}
	public String getErrorMsg(String s) {
		String errorMsg =(String)errors.get(s.trim());
		return (errorMsg == null) ? "":errorMsg;
	}

}
