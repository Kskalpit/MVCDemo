package mvcdemo.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/*import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;*/
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcdemo.controllers.ConnectionEst;

public class InsertForm {
	public static ArrayList<Employee> insertForm(Employee emp, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	try {
		emp.setEmployeeName(request.getParameter("InsertName"));
		emp.setEmail(request.getParameter("InsertEmail"));
		try {
			emp.setID(Integer.parseInt(request.getParameter("InsertID")));
			emp.setSalary(Integer.parseInt(request.getParameter("InsertSalary")));
		}
		catch (NumberFormatException e) {
			return null;
		}
		Connection conn = ConnectionEst.getConnection();
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Employees VALUES (?,?,?,?);");
		System.out.println(emp.getEmployeename());
		stmt.setString(1, emp.getEmployeename());
		stmt.setString(2,emp.getEmail());
		stmt.setInt(3, emp.getID());
		stmt.setInt(4, emp.getSalary());
		stmt.executeUpdate();
	}
	 catch (Exception e){
				return null;
	 }
	return null;
}
}
