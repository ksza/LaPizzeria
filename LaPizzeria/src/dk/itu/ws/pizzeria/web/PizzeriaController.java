package dk.itu.ws.pizzeria.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dk.itu.ws.pizzeria.model.Pizza;
import dk.itu.ws.pizzeria.model.User;
import dk.itu.ws.pizzeria.model.UserRole;
import dk.itu.ws.pizzeria.model.dao.GenericPizzaDAO;
import dk.itu.ws.pizzeria.model.dao.hibernate.HibernateDAOFactory;
import dk.itu.ws.pizzeria.model.dao.hibernate.HibernateUtil;
import dk.itu.ws.pizzeria.model.hibernate.HibernatePizza;
import dk.itu.ws.pizzeria.model.hibernate.HibernateUser;
import dk.itu.ws.pizzeria.model.hibernate.HibernateUserRole;

public class PizzeriaController extends HttpServlet {

	private static final String DB = "<html><head><title>TTTT</title><body><h1>DBs structure recreated!</h1></body></html>";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if(action != null) {
			
			if(action.equals("add_to_basket.do")) {
				HashMap<Pizza, Integer> pizzaChart = (HashMap<Pizza, Integer>)req.getSession().getAttribute("pizzaChart");
				
				GenericPizzaDAO pizzaDAO = HibernateDAOFactory.getInstance().getPizzaDAO();
			    Pizza newPizza = new HibernatePizza();
				newPizza = (Pizza)pizzaDAO.get(Long.parseLong(req.getParameter("pizza_id")));

				Integer quant = pizzaChart.get(newPizza);
		        pizzaChart.put(newPizza, (quant == null) ? 1 : quant + 1);

		        req.getSession().setAttribute("pizzaChart", pizzaChart);
		        getServletContext().getRequestDispatcher("/chart/shop.jsp").forward(req, resp);
			} else if (action.equals("delete_pizza_from_chart.do")){
				HashMap<Pizza, Integer> pizzaChart = (HashMap<Pizza, Integer>)req.getSession().getAttribute("pizzaChart");
				
				GenericPizzaDAO pizzaDAO = HibernateDAOFactory.getInstance().getPizzaDAO();
				Pizza deletePizza = new HibernatePizza();
				deletePizza = (Pizza)pizzaDAO.get(Long.parseLong(req.getParameter("pizza_id")));
		        Integer quant = pizzaChart.get(deletePizza);
		        if(quant > 1) {
		        	pizzaChart.put(deletePizza, quant - 1);
		        } else { 
		        	pizzaChart.remove(deletePizza);
		        }
		        req.getSession().setAttribute("pizzaChart", pizzaChart);
		        getServletContext().getRequestDispatcher("/chart/shop.jsp").forward(req, resp);
			} else if(action.equals("checkout.do")) {
				HashMap<Pizza, Integer> pizzaChart = (HashMap<Pizza, Integer>)req.getSession().getAttribute("pizzaChart");
				
				req.getSession().setAttribute("pizzaChart", pizzaChart);
				resp.sendRedirect("/LaPizzeria/chart/checkout.jsp");
			} else if (action.equals("confirm.do")){
				req.getSession().removeAttribute("pizzaChart");
				resp.sendRedirect("/LaPizzeria/chart/shop.jsp");
			} else if(action.equals("delete_pizza.do")) {
				GenericPizzaDAO pizzaDAO = HibernateDAOFactory.getInstance().getPizzaDAO();
				pizzaDAO.delete(pizzaDAO.get(Long.parseLong(req.getParameter("pizza_id"))));
				resp.sendRedirect("/LaPizzeria/admin/pizzas.jsp");
			} else if(action.equals("buy_pizza.do")) {
				resp.sendRedirect("/LaPizzeria/chart/shop.jsp");
			} else if(action.equals("admin.do")) {
				resp.sendRedirect("/LaPizzeria/admin/pizzas.jsp");
			} else if(action.equals("logout.do")) {
				
				req.getSession().invalidate();
				resp.sendRedirect("/LaPizzeria/index.jsp");
				
			} else if(action.equals("register.do")) {
				
				getServletContext().getRequestDispatcher("/auth/register.jsp").forward(req, resp);
				
			} else if(action.equals("process_registration.do")) {
				User newUser = new HibernateUser();
				newUser.setName(req.getParameter("name"));
				newUser.setPhoneNo(req.getParameter("phoneNo"));
				newUser.setAddress(req.getParameter("address"));
				newUser.setZipCode(req.getParameter("zipCode"));
				newUser.setEmail(req.getParameter("email"));
				newUser.setPassword(req.getParameter("password"));
				
				req.setAttribute("newUser", newUser);
				
				if(newUser.validate()) {
					HibernateDAOFactory.getInstance().getUserDAO().saveOrUpdate(newUser);
					
					UserRole userRole = new HibernateUserRole();
					userRole.setUserName(newUser.getEmail());
					userRole.setUserRole(UserRole.ROLE_USER);
					
					HibernateDAOFactory.getInstance().getUserRoleDAO().saveOrUpdate(userRole);
					
					getServletContext().getRequestDispatcher("/auth/successful_registration.jsp").forward(req, resp);
				} else {
					getServletContext().getRequestDispatcher("/auth/retry_registration.jsp").forward(req, resp);
				}
				
			} else if (action.equals("add_pizza.do")) {
				Pizza p = new HibernatePizza();
				p.setName(req.getParameter("pizzaName"));
				p.setDescription(req.getParameter("description"));
				p.setPrice(Double.parseDouble(req.getParameter("price")));
				
				req.setAttribute("newPizza", p);
				if (p.validate()){
					HibernateDAOFactory.getInstance().getPizzaDAO().saveOrUpdate(p);
				}
				getServletContext().getRequestDispatcher("/admin/pizzas.jsp").forward(req, resp);
			} else if(action.equals("recreate_db.do")) {
				HibernateUtil.recreateDatabase();
				
				User newUser = new HibernateUser();
				newUser.setName("Admin");
				newUser.setPhoneNo("12345678");
				newUser.setAddress("my_address");
				newUser.setZipCode("1234");
				newUser.setEmail("admin@itu");
				newUser.setPassword("test_22");
				
				HibernateDAOFactory.getInstance().getUserDAO().saveOrUpdate(newUser);
				
				UserRole userRole = new HibernateUserRole();
				userRole.setUserName(newUser.getEmail());
				userRole.setUserRole(UserRole.ROLE_USER);
				HibernateDAOFactory.getInstance().getUserRoleDAO().saveOrUpdate(userRole);
				
				userRole.setUserRole(UserRole.ROLE_ADMIN);
				HibernateDAOFactory.getInstance().getUserRoleDAO().saveOrUpdate(userRole);
				
				Pizza newPizza = new HibernatePizza();
				newPizza.setName("Margarita");
				newPizza.setDescription("Tomato sauce, Mozzarela");
				newPizza.setPrice(Double.parseDouble("40"));
				
				HibernateDAOFactory.getInstance().getPizzaDAO().saveOrUpdate(newPizza);
							
				resp.getWriter().print(DB);
			} else {
				getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
			}
			
		} else {
			getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
	
}
