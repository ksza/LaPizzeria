package dk.itu.ws.pizzeria.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dk.itu.ws.pizzeria.model.User;

/**
 * TODO: not working yet!
 * @author spazzy
 *
 */
public class UserAsAdminFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void destroy() { }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		if (session != null) {
			User activeUser = (User)session.getAttribute("activeUser");

//			if(activeUser.userInRole(Role.ADMIN)) {
//				filterChain.doFilter(request, response);
//			} else {
//				filterConfig.getServletContext().getRequestDispatcher("/auth/login.jsp").forward(request, response);
//			}
		} else {
			filterConfig.getServletContext().getRequestDispatcher("/auth/login.jsp").forward(request, response);
		}
		response.getWriter().println("<html><head><title>TTTT</title><body><h1>Filtering!</h1></body></html>");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
