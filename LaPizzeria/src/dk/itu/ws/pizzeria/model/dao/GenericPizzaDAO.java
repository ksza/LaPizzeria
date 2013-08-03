package dk.itu.ws.pizzeria.model.dao;

import java.util.List;

import dk.itu.ws.pizzeria.model.Pizza;

public interface GenericPizzaDAO<K extends Pizza>  extends GenericDAO<Long, K> {
	
	public List<K> findByName(String value);

}
