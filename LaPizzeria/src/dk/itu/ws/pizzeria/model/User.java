package dk.itu.ws.pizzeria.model;

public abstract class User {

	private Long id;
	private String email;
	private String password;
	private String name;
	private String address;
	private String zipCode;
	private String phoneNo;
	private Boolean valid;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
	/**
	 * Validate all the field of the current entity
	 * @return true if valid
	 */
	public abstract boolean validate();
	/**
	 * Get specific error messages for each field from the last validation
	 * 
	 * @param s
	 * @return
	 */
	public abstract String getErrorMsg(String s);

}
