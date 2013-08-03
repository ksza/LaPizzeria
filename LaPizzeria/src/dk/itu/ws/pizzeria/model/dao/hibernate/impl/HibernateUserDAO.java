package dk.itu.ws.pizzeria.model.dao.hibernate.impl;

import java.util.List;

import dk.itu.ws.pizzeria.model.dao.GenericUserDAO;
import dk.itu.ws.pizzeria.model.hibernate.HibernateUser;

public class HibernateUserDAO extends HibernateGenericDAO<Long, HibernateUser> implements GenericUserDAO<HibernateUser>  {

	public HibernateUserDAO() {
		super(HibernateUser.class);
	}
	
	@Override
	public List<HibernateUser> findByEmail(String value) {
		return super.findByField("email", value);
	}

}
