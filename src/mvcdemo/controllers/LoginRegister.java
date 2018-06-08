package mvcdemo.controllers;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import mvcdemo.controllers.ConnectionEst;

/*import javax.servlet.RequestDispatcher;*/
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/*import mvcdemo.model.Authenticator;
import mvcdemo.model.User;*/

public class LoginRegister extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7639889932813710005L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter ("email");
		
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		try {
			Connection conn = ConnectionEst.getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO USER VALUES (?,?,?)");
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, email);
			
			int i = stmt.executeUpdate();
			
			if (i>0) {
			out.println("User Added Successfully");}
			
			//conn.close();
			
		}
		catch (Exception e){
			System.out.println(e);
			
		}
			
			
			
			
			/*RequestDispatcher rd = null;
		
		Authenticator authenticator = new Authenticator();
		String result = authenticator.authenticate(username, password);
		if (result.equals("success")) {
			rd = request.getRequestDispatcher("success.jsp");
			User user = new User(username, password);
			request.setAttribute("user", user);
		} else {
			rd = request.getRequestDispatcher("error.jsp");
		}
		rd.forward(request, response);*/
	}
}