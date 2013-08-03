package dk.itu.ws.pizzeria.model.dao.hibernate.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import dk.itu.ws.pizzeria.model.dao.GenericDAO;
import dk.itu.ws.pizzeria.model.dao.hibernate.HibernateUtil;

public class HibernateGenericDAO<K extends Serializable, T> implements GenericDAO<K, T> {

	private Class<T> type;

	public HibernateGenericDAO(Class<T> type) {
		this.type = type;
	}

	public T get(K id) {
		getSession().beginTransaction();
		return (T) getSession().get(type, id);
	}

	public List<T> findAll() {
		getSession().beginTransaction();
		return getSession().createCriteria(type).list();
	}

	public void saveOrUpdate(T o) {
		getSession().beginTransaction();

		try {
			getSession().saveOrUpdate(o);
			getSession().getTransaction().commit();
		} catch (HibernateException e) {
			getSession().getTransaction().rollback();
		}
	}

	public void delete(T o) {
		getSession().beginTransaction();

		try {
			getSession().delete(o);
			getSession().getTransaction().commit();
		} catch (HibernateException e) {
			getSession().getTransaction().rollback();
		}
	}

	protected Session getSession() {
		return HibernateUtil.getSession();
	}

	@Override
	public List<T> findByField(String field, Object value) {
		getSession().beginTransaction();

		try {
			return getSession().createCriteria(type)
			.add(Restrictions.eq(field, value)).list();
		} catch (HibernateException e) {
			getSession().getTransaction().rollback();
		}

		return null;
	}

	public Class<T> getType() {
		return type;
	}
}
