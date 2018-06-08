package mvcdemo.controllers;

import java.util.ArrayList;
/*import java.util.Arrays;*/
//import java.util.LinkedHashMap;
//import java.util.List;
/*import java.util.List;
import mvcdemo.model.Filter;*/
//import mvcdemo.model.DatabaseModel;
import mvcdemo.model.Employee;

import mvcdemo.model.InsertForm;
/*import mvcdemo.model.SearchForm;*/
import mvcdemo.model.FilterForm;

import java.io.IOException;
import java.io.PrintWriter;

//import java.io.PrintWriter;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import mvcdemo.model.Employee;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import javax.servlet.http.HttpSession;
import mvcdemo.model.Pagination;*/

//import mvcdemo.model.User;
//import com.google.gson;
import com.google.gson.Gson;
import mvcdemo.model.FilterSearch;

public class SearchDatabase extends HttpServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = 7668481730619318849L;

	public void init() {

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/*int currentPage = Integer.parseInt((String) request.getParameter("page"));
		Employee emp = new Employee();
		Pagination.pagination(emp, request, response, currentPage);
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/ViewDatabase.jsp");
		rd.forward(request, response);*/
		try {
			Employee emp = new Employee();
			//RequestDispatcher rds = null;
			//System.out.println(request.getParameter("FilterState"));
			//HttpSession session = request.getSession(false);
			/*if (session == null) {
				response.sendRedirect("login.jsp");
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
				response.setDateHeader("Expires", 0);
				rds = request.getRequestDispatcher("login.jsp");
				rds.forward(request, response);
			}*/
			if (request.getParameter("InsertForm") != null) {
				ArrayList<Employee> empl = InsertForm.insertForm(emp, request, response);
				if (empl == null) {
					String s = "Fields not present!";
					request.setAttribute("EmployeeError", s);
				} else {
					request.removeAttribute("EmployeeError");
				}
				request.setAttribute("Employee", empl);
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/ViewDatabase.jsp");
				rd.forward(request, response);
			} 
			else if (request.getParameter("FilterState") != null) {
				String obj = (String) request.getParameter("test");
				//System.out.println(obj);
				//System.out.println("Hi " + request.getParameter("FilterState"));
				FilterSearch filterSearch = new FilterSearch(obj);
				//System.out.println("xdf");
				Gson gson = new Gson();
				//System.out.println("adf");
				filterSearch = gson.fromJson(obj, FilterSearch.class);
				//System.out.println(filterSearch.getFilter().size());
				int currentPage = 1;
				FilterForm.filterForm(request, response, filterSearch, currentPage);
				/*List<Filter> x= new ArrayList<>();
				x = filterSearch.getFilter();
				//System.out.println(obj);
				//String json = new Gson().toJson(list);
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/ViewDatabase.jsp");
				rd.forward(request, response);
				*/
				//System.out.println(x.get(0));
				
				
				
				
				//System.out.println("asfkh");
			}
			else {
				/*String obj = request.getParameter("test");
				System.out.println(obj);
				FilterSearch filterSearch = new FilterSearch(obj);
				filterSearch.setmyList(obj[]));*/
			}
			/*else if (request.getParameter("FilterState")==null) {
				int currentPage = 1;
				SearchForm.searchForm(emp, request, response, currentPage);
				
				// System.out.println(json);
				
				 * //HttpSession session = request.getSession(true);
				 * request.setAttribute("EmployeesArr", empls); request.setAttribute("Para", 1);
				 * request.setAttribute("EmployeeesArr", empls);
				 
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");

				//response.getWriter().write(json);
*/			  /*else if (request.getParameter("Search") != null) {
				int currentPage = 1;
				SearchForm.searchForm(emp, request, response, currentPage);
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/ViewDatabase.jsp");
				rd.forward(request, response);
			}*/
	} catch (Exception e) {
			
			PrintWriter out = response.getWriter();
			e.printStackTrace();
			//response.setAttribute("Error", "Login Error!");
			System.out.println(e);
			out.println("<a href=\"http://localhost:8080/MVCDemo/login.jsp\">login</a>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			Employee emp = new Employee();
			//RequestDispatcher rds = null;
			//System.out.println(request.getParameter("FilterState"));
			//HttpSession session = request.getSession(false);
			/*if (session == null) {
				response.sendRedirect("login.jsp");
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
				response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
				response.setDateHeader("Expires", 0);
				rds = request.getRequestDispatcher("login.jsp");
				rds.forward(request, response);
			}*/
			if (request.getParameter("InsertForm") != null) {
				ArrayList<Employee> empl = InsertForm.insertForm(emp, request, response);
				if (empl == null) {
					String s = "Fields not present!";
					request.setAttribute("EmployeeError", s);
				} else {
					request.removeAttribute("EmployeeError");
				}
				request.setAttribute("Employee", empl);
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/ViewDatabase.jsp");
				rd.forward(request, response);
			} 
			else if (request.getParameter("FilterState") != null) {
				String obj = (String) request.getParameter("test");
				//System.out.println(obj);
				FilterSearch filterSearch = new FilterSearch(obj);
				//System.out.println("xdf");
				Gson gson = new Gson();
				//System.out.println("adf");
				filterSearch = gson.fromJson(obj, FilterSearch.class);
				//System.out.println(filterSearch);
				int currentPage = 1;
				FilterForm.filterForm(request, response, filterSearch, currentPage);
				/*List<Filter> x= new ArrayList<>();
				x = filterSearch.getFilter();*/
				//System.out.println(obj);
				//String json = new Gson().toJson(list);
				/*ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/ViewDatabase.jsp");
				rd.forward(request, response);*/
				
				/*System.out.println(x.get(0));
				
				*/
				
				
				//System.out.println("asfkh");
			}
			/*else if (request.getParameter("FilterState")==null) {
				int currentPage = 1;
				SearchForm.searchForm(emp, request, response, currentPage);
				
				// System.out.println(json);
				
				 * //HttpSession session = request.getSession(true);
				 * request.setAttribute("EmployeesArr", empls); request.setAttribute("Para", 1);
				 * request.setAttribute("EmployeeesArr", empls);
				 
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");

				//response.getWriter().write(json);
*/			  /*else if (request.getParameter("Search") != null) {
				int currentPage = 1;
				SearchForm.searchForm(emp, request, response, currentPage);
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/ViewDatabase.jsp");
				rd.forward(request, response);
			}*/
	} catch (Exception e) {
			
			PrintWriter out = response.getWriter();
			e.printStackTrace();
			//response.setAttribute("Error", "Login Error!");
			System.out.println(e);
			out.println("<a href=\"http://localhost:8080/MVCDemo/login.jsp\">login</a>");
		}
	}
}