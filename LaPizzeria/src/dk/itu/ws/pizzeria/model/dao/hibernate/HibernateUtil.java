package dk.itu.ws.pizzeria.model.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import dk.itu.ws.pizzeria.model.hibernate.HibernatePizza;
import dk.itu.ws.pizzeria.model.hibernate.HibernateUser;
import dk.itu.ws.pizzeria.model.hibernate.HibernateUserRole;

public class HibernateUtil {

	private static SessionFactory factory;

	public static Configuration getInitializedConfiguration() {
		Configuration config = new Configuration();

		config.addAnnotatedClass(HibernateUser.class);
		config.addAnnotatedClass(HibernateUserRole.class);
		config.addAnnotatedClass(HibernatePizza.class);
		
		config.configure();
		return config;
	}

	public static void recreateDatabase() {
		Configuration config;
		config = HibernateUtil.getInitializedConfiguration();
		new SchemaExport(config).create(true, true); 
	}

	public static Session getSession() {
		if (factory == null) {
			Configuration config =
				HibernateUtil.getInitializedConfiguration();
			factory = config.buildSessionFactory();
		}
		Session hibernateSession = factory.getCurrentSession();
		return hibernateSession;
	}
	
}
