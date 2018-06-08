package mvcdemo.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mvcdemo.controllers.ConnectionEst;

public class SearchForm {
	public static void searchForm(Employee emp, HttpServletRequest request, HttpServletResponse response, int currentPage) throws IOException, ServletException {
		try {
			String s = request.getParameter("Search");
			if (s.equals("")) { 
				Connection conn = ConnectionEst.getConnection();
				//String z = request.getParameter("filterRange");
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employees ORDER BY " + request.getParameter("orderBy")+ " ASC" );
				LinkedHashMap <Integer, Employee> empl = DatabaseModel.getAllEmployees(stmt);
				int noOfRecords = empl.size();
	            //int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / 10);
	            int x = (currentPage-1)*10;
	            List<Employee> empls = new ArrayList<Employee>();
	            for(int i=1; i<=10; i++) {
	            	if(i+x<=noOfRecords) {empls.add(empl.get(x + i));}
	            	else {break;}
	            }
	            Gson gson = new Gson();
				String json = gson.toJson(empls);
				// System.out.println(empls);

				// System.out.println(json);
				/*
				 * //HttpSession session = request.getSession(true);
				 * request.setAttribute("EmployeesArr", empls); request.setAttribute("Para", 1);
				 * request.setAttribute("EmployeeesArr", empls);
				 */
				// System.out.println("Exit");
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");

				response.getWriter().write(json);
	            /*request.setAttribute("EmployeesArr", empls); 
	            request.setAttribute("noOfPages", noOfPages);
	            request.setAttribute("currentPage", currentPage);
	            request.setAttribute("Search", s);
	            request.setAttribute("search", (String)request.getParameter("myList"));
	            request.setAttribute("order", (String)request.getParameter("orderBy"));*/
				
			}
			else {
			Connection conn = ConnectionEst.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employees WHERE " + request.getParameter("myList") +" =?" + " ORDER BY " + request.getParameter("orderBy") + " ASC" );
			stmt.setString(1, s);
			LinkedHashMap <Integer, Employee> empl = DatabaseModel.getAllEmployees(stmt);
			//System.out.println());
			int noOfRecords = empl.size();
            //int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / 10);
            int x = (currentPage-1)*10;
            List<Employee> empls = new ArrayList<Employee>();
            for(int i=1; i<=10; i++) {
            	if(i+x<=noOfRecords) {empls.add(empl.get(x + i));}
            	else {break;}
            }
            //System.out.println(empls.get(0));
            Gson gson = new Gson();
			String json = gson.toJson(empls);
			// System.out.println(empls);

			// System.out.println(json);
			/*
			 * //HttpSession session = request.getSession(true);
			 * request.setAttribute("EmployeesArr", empls); request.setAttribute("Para", 1);
			 * request.setAttribute("EmployeeesArr", empls);
			 */
			// System.out.println("Exit");
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			response.getWriter().write(json);
            /*request.setAttribute("EmployeesArr", empls); 
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("Search", s);
            request.setAttribute("search", (String)request.getParameter("myList"));
            request.setAttribute("order", (String)request.getParameter("orderBy"));*/
	}}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}

	