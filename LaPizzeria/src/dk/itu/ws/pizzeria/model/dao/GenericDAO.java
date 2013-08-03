package dk.itu.ws.pizzeria.model.dao;

import java.util.List;

public interface GenericDAO<K, T> {

	/** 
	 * Retrieve an object that was previously persisted to the database using
	 * the indicated id as primary key
	 */
	public T get(K id);

	public List<T> findAll();

	public void saveOrUpdate(T transientObject);

	/** Remove an object from persistent storage in the database */
	public void delete(T persistentObject);
	
	public List<T> findByField(String field, Object value);
}
