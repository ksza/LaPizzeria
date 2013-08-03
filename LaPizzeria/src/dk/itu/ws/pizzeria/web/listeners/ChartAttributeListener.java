package dk.itu.ws.pizzeria.web.listeners;

import java.util.HashMap;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import dk.itu.ws.pizzeria.model.Pizza;

public class ChartAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		event.getSession().setAttribute("pizzaChart", new HashMap<Pizza, Integer>());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
	}

}
