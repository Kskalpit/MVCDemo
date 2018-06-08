package mvcdemo.controllers;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.Filter;
import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.

		chain.doFilter(req, res);
	}
*/
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login.jsp";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache"); 
			response.setDateHeader("Expires", 0);
		}
		PrintWriter out = response.getWriter();

		session.invalidate();
		//request.getSession().invalidate();
        //response.sendRedirect(request.getContextPath() + "/LoginPage.html");

		out.print("You are successfully logged out!");

		out.close();
	}

/*	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}*/
}
