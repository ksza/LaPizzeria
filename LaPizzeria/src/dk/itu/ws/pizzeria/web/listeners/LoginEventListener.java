package dk.itu.ws.pizzeria.web.listeners;

import java.util.HashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dk.itu.ws.pizzeria.model.Pizza;

public class LoginEventListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		sessionEvent.getSession().setAttribute("pizzaChart", new HashMap<Pizza, Integer>());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("destroyed!!");
	}

}
