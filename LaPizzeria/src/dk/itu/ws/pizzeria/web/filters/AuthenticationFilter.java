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

public class AuthenticationFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		try {
			boolean authorized = false;

			if (request instanceof HttpServletRequest) {
				HttpSession session = ((HttpServletRequest)request).getSession(false);
				if (session != null) {
					User activeUser = (User)session.getAttribute("activeUser");
					String requestAction = ((HttpServletRequest)request).getParameter("action");

					// avoid vicious circle :)
					if((activeUser != null) || "login.do".equalsIgnoreCase(requestAction)) {
						authorized = true;
					}
				}
			}

			if (authorized) {
				filterChain.doFilter(request, response);
			} else {
				filterConfig.getServletContext().getRequestDispatcher("/auth/login.jsp").forward(request, response);
			}
		} catch (IOException io) {
			System.out.println("IOException raised in AuthenticationFilter");
		} catch (ServletException se) {
			System.out.println("ServletException raised in AuthenticationFilter");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
