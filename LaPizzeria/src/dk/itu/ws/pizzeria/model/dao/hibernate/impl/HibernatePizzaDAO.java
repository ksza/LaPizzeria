package dk.itu.ws.pizzeria.model.dao.hibernate.impl;

import java.util.List;

import org.hibernate.criterion.Order;

import dk.itu.ws.pizzeria.model.dao.GenericPizzaDAO;
import dk.itu.ws.pizzeria.model.hibernate.HibernatePizza;

public class HibernatePizzaDAO extends HibernateGenericDAO<Long, HibernatePizza> implements GenericPizzaDAO<HibernatePizza> {

	public HibernatePizzaDAO() {
		super(HibernatePizza.class);
	}
	
	@Override
	public List<HibernatePizza> findByName(String value) {
		return super.findByField("name", value);
	}
	
	@Override
	public List<HibernatePizza> findAll() {
		getSession().beginTransaction();
		return getSession().createCriteria(super.getType()).addOrder(Order.asc("name")).list();
	}

}
