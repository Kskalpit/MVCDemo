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

import mvcdemo.controllers.ConnectionEst;

public class Pagination {
	public static void pagination(Employee emp, HttpServletRequest request, HttpServletResponse response, int currentPage) throws IOException, ServletException {
		try {
			
			String s = (String)request.getParameter("search");
			String m = (String)request.getParameter("searchBy");
			
			Connection conn = ConnectionEst.getConnection();
			String o = (String)request.getParameter("orderBy");
			PreparedStatement stmt = null;
			if (s.equals("")) {
				stmt = conn.prepareStatement("SELECT * FROM Employees ORDER BY " + o + " ASC" );	
			}
			else {
				stmt = conn.prepareStatement("SELECT * FROM Employees WHERE " + m +" =?" + "ORDER BY " + o + " ASC" );
				stmt.setString(1, s);
			}
			
			LinkedHashMap <Integer, Employee> empl = DatabaseModel.getAllEmployees(stmt);
			int noOfRecords = empl.size();
	        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / 10);
            int x = (currentPage-1)*10;
	        List<Employee> empls = new ArrayList<Employee>();
	        for(int i=1; i<=10; i++) {
	        	if(i+x<=noOfRecords) {empls.add(empl.get(x + i));}
            	else {break;}

	        }
	        
	        request.setAttribute("EmployeesArr", empls); 
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", currentPage);
	        request.setAttribute("Search", s);
	        request.setAttribute("search", m);
	        request.setAttribute("order", o);}
		catch (Exception e) {
			System.out.println(e);
		}
}}

