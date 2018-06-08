package mvcdemo.model;

import java.io.IOException;
/*import java.io.IOException;
import java.io.PrintWriter;*/
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

import javax.servlet.ServletException;

import mvcdemo.controllers.ConnectionEst;

/*import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

public class Authenticator  {
	public String authenticate (String username, String password) throws IOException, ServletException{
		//private static final long serialVersionUID = 1L;
			/*String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter ("email");*/
			
			/*response.setContentType("text/html");
			PrintWriter out = response.getWriter();*/
			
			
			try {
				Connection conn = ConnectionEst.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT PASSWORD from USER where NAME=?");
				
				stmt.setString(1, username);
				
				ResultSet rs = stmt.executeQuery();
				
				rs.next();

				
				String x = rs.getString("password");
				if(x.equals(password)) {
					return "success";
				}
				else
				{
					return "fail";
				}
				
				/*int i = stmt.executeUpdate();*/
				
				/*if (i>0) {
				out.println(i + "User Added Successfully");}
				
				con.close();*/

			}
			catch (Exception e){
				System.out.println(e);
				return "fail";
			}
		
		
		
		
		/*if("admin".equalsIgnoreCase(username) && "admin@123".equals(password)) {
			return "true";
		}
		else {
			return "false";
		}
		}*/
		
	}
	}
