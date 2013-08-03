package dk.itu.ws.pizzeria.model;

public abstract class UserRole {
	
	public static final String ROLE_USER = "USER";
	public static final String ROLE_ADMIN = "ADMIN";
	
	private Long id;
	private String userName;
	private String userRole;
	
	public UserRole() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}
