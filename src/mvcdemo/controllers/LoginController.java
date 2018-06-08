package mvcdemo.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvcdemo.model.Authenticator;
import mvcdemo.model.User;

public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4063736972450792313L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		//String id = session.getId();
		//String user = (String) getAttribute()
		session.setAttribute("UserSession", username);
		
		
		Authenticator authenticator = new Authenticator();
		String result = authenticator.authenticate(username, password);
		if (result.equals("success")) {
			rd = request.getRequestDispatcher("ViewDatabase.jsp");
			
			User user = new User(username, password);
			request.setAttribute("user", user);
		} else {
			rd = request.getRequestDispatcher("error.jsp");
		}
		rd.forward(request, response);
		
		
	}
}