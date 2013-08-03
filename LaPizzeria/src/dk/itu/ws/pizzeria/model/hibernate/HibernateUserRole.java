package dk.itu.ws.pizzeria.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import dk.itu.ws.pizzeria.model.UserRole;

@Entity
@Table(name = "user_roles", schema = "lapizzeria")
public class HibernateUserRole extends UserRole {

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return super.getId();
	}

	@Column(name = "email", nullable = false)
	public String getUserName() {
		return super.getUserName();
	}
	
	@Column(name = "role", nullable = false)
	public String getUserRole() {
		return super.getUserRole();
	}
	
}
