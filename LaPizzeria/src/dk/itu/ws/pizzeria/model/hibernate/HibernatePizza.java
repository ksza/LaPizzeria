package dk.itu.ws.pizzeria.model.hibernate;

import java.util.Hashtable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import dk.itu.ws.pizzeria.model.Pizza;
import dk.itu.ws.pizzeria.model.dao.hibernate.HibernateDAOFactory;

@Entity
@Table(name = "pizzas", schema = "lapizzeria")
public class HibernatePizza extends Pizza {

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId() {
		return super.getId();
	}

	@Column(name = "name", nullable = false, unique = true)
	public String getName() {
		return super.getName();
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return super.getDescription();
	}

	@Column(name = "price", nullable = false)
	public double getPrice() {
		return super.getPrice();
	}

	/* ***************** utility methods **************** */
	@Transient
	private Hashtable<String, String> errors = new Hashtable<String, String>();

	public boolean validate() {
		boolean valid = true;

		errors.clear();

		if (super.getName() == null || super.getName().equals("")) {
			errors.put("name", "Please provide a name for the pizza");
			super.setName("");
			valid = false;
		} else {
			List<HibernatePizza> result = HibernateDAOFactory.getInstance()
					.getPizzaDAO().findByName(super.getName());
			if (result != null && result.size() > 0) {
				errors.put("name", "A pizza with this name already exists!");
				valid = false;
			}
		}
		if (super.getDescription() == null || super.getDescription().equals("")) {
			errors.put("description",
					"You must provide a description for the pizza");
			super.setDescription("");
			valid = false;
		}

		if (Double.toString(super.getPrice()) == null || Double.toString(super.getPrice()).equals("") || super.getPrice() == 0 || super.getPrice() == 0) {
			errors.put("price", "You must provide a price");
			super.setPrice(0);
			valid = false;
		}

		return valid;
	}

	public String getErrorMsg(String s) {
		String errorMsg = (String) errors.get(s.trim());
		return (errorMsg == null) ? "" : errorMsg;
	}
}
