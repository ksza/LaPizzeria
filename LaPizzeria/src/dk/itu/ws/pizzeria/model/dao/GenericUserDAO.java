package dk.itu.ws.pizzeria.model.dao;

import java.util.List;

import dk.itu.ws.pizzeria.model.User;

public interface GenericUserDAO<K extends User> extends GenericDAO<Long, K> {

	public List<K> findByEmail(String value);
	
}
