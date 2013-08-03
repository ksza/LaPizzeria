package dk.itu.ws.pizzeria.model.dao.hibernate;

import dk.itu.ws.pizzeria.model.UserRole;
import dk.itu.ws.pizzeria.model.dao.GenericDAO;
import dk.itu.ws.pizzeria.model.dao.GenericPizzaDAO;
import dk.itu.ws.pizzeria.model.dao.GenericUserDAO;
import dk.itu.ws.pizzeria.model.dao.hibernate.impl.HibernateGenericDAO;
import dk.itu.ws.pizzeria.model.dao.hibernate.impl.HibernatePizzaDAO;
import dk.itu.ws.pizzeria.model.dao.hibernate.impl.HibernateUserDAO;

public class HibernateDAOFactory {

	private static HibernateDAOFactory instance;

	private HibernateDAOFactory() { }

	public static HibernateDAOFactory getInstance() {
		if(instance == null) {
			instance = new HibernateDAOFactory();
		}

		return instance;
	}

	public GenericUserDAO getUserDAO() {
		return new HibernateUserDAO();
	}
	
	public GenericDAO<Long, UserRole> getUserRoleDAO() {
		return new HibernateGenericDAO<Long, UserRole>(UserRole.class);
	}
	
	public GenericPizzaDAO getPizzaDAO() {
		return new HibernatePizzaDAO();
	}
}
