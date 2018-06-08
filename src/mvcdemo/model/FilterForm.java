package mvcdemo.model;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import mvcdemo.controllers.ConnectionEst;
import mvcdemo.model.FilterSearch;

public class FilterForm {
	public static void filterForm(HttpServletRequest request, HttpServletResponse response, FilterSearch filterSearch,
			int currentPage) throws IOException, ServletException {
		try {
			String s = filterSearch.getSearch();
			//System.out.println("Test" + s);
			//System.out.println(filterSearch.getFilter().get(0).getvalue());
			// System.out.println(s);
			// System.out.println(filterSearch.getFilter().get(0).getoperator());
			if (s.isEmpty() && !filterSearch.getFilter().isEmpty()) {
				Connection conn = ConnectionEst.getConnection();
				// String a = "";
				String query = "";
				query = "SELECT * FROM Employees WHERE ";
				System.out.println(filterSearch.getFilter().get(0).getvalue() );
				System.out.println("Tets");
				for (int i = 0; i < filterSearch.getFilter().size(); i++) {
					// if(filterSearch.getFilter().get(i).getvalue().)
					query += filterSearch.getFilter().get(i).getField() + " "
							+ filterSearch.getFilter().get(i).getoperator() + " "
							+ filterSearch.getFilter().get(i).getvalue();
					if (i != filterSearch.getFilter().size() - 1) {
						query += " AND ";
					}
				}
				query += " ORDER BY " + filterSearch.getorderBy() + " ASC;";
				System.out.println(query);
				// System.out.println("adfadf");
				// a = filterSearch.getFilter().get(0).getoperator();
				// query = "SELECT * FROM Employees;";

				// System.out.println(query);
				// String z = request.getParameter("filterRange");
				PreparedStatement stmt = conn.prepareStatement(query);
				LinkedHashMap<Integer, Employee> empl = DatabaseModel.getAllEmployees(stmt);
				int noOfRecords = empl.size();
				// int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / 10);
				int x = (currentPage - 1) * 10;
				List<Employee> empls = new ArrayList<Employee>();
				for (int i = 1; i <= 10; i++) {
					if (i + x <= noOfRecords) {
						empls.add(empl.get(x + i));
					} else {
						break;
					}
				}
				/* System.out.println(filterSearch.getmyList()); */
				// System.out.println(empls.get(0));

				String json = new Gson().toJson(empls);

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");

				response.getWriter().write(json);
				// System.out.println(json);

			} 
			else if(filterSearch.getFilter().isEmpty() && s.isEmpty()) {
				Connection conn = ConnectionEst.getConnection();
				String query = "";
				//System.out.println("Tets2");
				// System.out.println(filterSearch.getFilter().get(0).getvalue());
				/*query = "SELECT * FROM Employees WHERE " + filterSearch.getmyList() + " =?";
				// System.out.println(filterSearch.getFilter().get(0).getvalue() );
				// System.out.println("Tets");
				
				query += " ORDER BY " + filterSearch.getorderBy() + " ASC;";
				// query = "SELECT * FROM Employees;";
				// System.out.println(query);
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, s);*/
				query = "SELECT * FROM Employees ORDER BY " + filterSearch.getorderBy() + " ASC;";
				PreparedStatement stmt = conn.prepareStatement(query);
				LinkedHashMap<Integer, Employee> empl = DatabaseModel.getAllEmployees(stmt);
				int noOfRecords = empl.size();
				//int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / 10);
				int x = (currentPage - 1) * 10;
				List<Employee> empls = new ArrayList<Employee>();
				for (int i = 1; i <= 10; i++) {
					if (i + x <= noOfRecords) {
						empls.add(empl.get(x + i));
					} else {
						break;
					}
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
				// System.out.println("Exit");

				/*request.setAttribute("noOfPages", noOfPages);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("Search", s);
				request.setAttribute("search", filterSearch.getmyList());
				request.setAttribute("order", filterSearch.getorderBy());*/
			}
			else if(!filterSearch.getFilter().isEmpty() && !s.isEmpty()){
				// System.out.println("cvj");
				Connection conn = ConnectionEst.getConnection();
				// String a = "";
				String query = "";
				query = "SELECT * FROM Employees WHERE " + filterSearch.getmyList() + "=? AND ";
				//System.out.println(filterSearch.getFilter().get(0).getvalue() );
				//System.out.println("Tets");
				for (int i = 0; i < filterSearch.getFilter().size(); i++) {
					// if(filterSearch.getFilter().get(i).getvalue().)
					query += filterSearch.getFilter().get(i).getField() + " "
							+ filterSearch.getFilter().get(i).getoperator() + " "
							+ filterSearch.getFilter().get(i).getvalue();
					if (i != filterSearch.getFilter().size() - 1) {
						query += " AND ";
					}
				}
				query += " ORDER BY " + filterSearch.getorderBy() + " ASC;";
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, s);
				//System.out.println(query);

				LinkedHashMap<Integer, Employee> empl = DatabaseModel.getAllEmployees(stmt);
				int noOfRecords = empl.size();
				//int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / 10);
				int x = (currentPage - 1) * 10;
				List<Employee> empls = new ArrayList<Employee>();
				for (int i = 1; i <= 10; i++) {
					if (i + x <= noOfRecords) {
						empls.add(empl.get(x + i));
					} else {
						break;
					}
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
				// System.out.println("Exit");
/*
				request.setAttribute("noOfPages", noOfPages);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("Search", s);
				request.setAttribute("search", filterSearch.getmyList());
				request.setAttribute("order", filterSearch.getorderBy());*/

				// System.out.println(json);

			}
			else /*if(filterSearch.getFilter().isEmpty() && !s.isEmpty())*/{
				// System.out.println("cvj");
				Connection conn = ConnectionEst.getConnection();
				//System.out.println("Tets3");
				String query = "";
				// System.out.println(filterSearch.getFilter().get(0).getvalue());
				query = "SELECT * FROM Employees WHERE " + filterSearch.getmyList() + " =?";
				// System.out.println(filterSearch.getFilter().get(0).getvalue() );
				// System.out.println("Tets");
				query += " ORDER BY " + filterSearch.getorderBy() + " ASC;";
				// query = "SELECT * FROM Employees;";
				// System.out.println(query);
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, s);

				LinkedHashMap<Integer, Employee> empl = DatabaseModel.getAllEmployees(stmt);
				int noOfRecords = empl.size();
				//int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / 10);
				int x = (currentPage - 1) * 10;
				List<Employee> empls = new ArrayList<Employee>();
				for (int i = 1; i <= 10; i++) {
					if (i + x <= noOfRecords) {
						empls.add(empl.get(x + i));
					} else {
						break;
					}
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
				// System.out.println("Exit");

				/*request.setAttribute("noOfPages", noOfPages);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("Search", s);
				request.setAttribute("search", filterSearch.getmyList());
				request.setAttribute("order", filterSearch.getorderBy());*/

				// System.out.println(json);

			}
		} catch (Exception e) {
			e.printStackTrace();
			
			System.out.println("FilterFormException");
			// System.out.println("adfsdfs");
		}
	}
}
