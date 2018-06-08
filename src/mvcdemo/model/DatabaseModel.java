package mvcdemo.model;
//import mvcdemo.controllers.ConnectionEst;
import mvcdemo.model.Employee;
//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.LinkedHashMap;
//import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.ResultSetMetaData;


/*import javax.servlet.RequestDispatcher;*/

public class DatabaseModel {
	
	public Employee emp (ResultSet rs) throws SQLException{
		//ResultSetMetaData metaData = rs.getMetaData();
		//int rowCount = metaData.getColumnCount();
		
		String u = rs.getString("Name");
		String e = rs.getString("Email");
		int i = rs.getInt("ID");
		int s = rs.getInt("Salary");
		
		Employee employee = new Employee(u,e,i,s);
		
		
		return employee ;
	}
	
	public static LinkedHashMap<Integer, Employee> getAllEmployees(PreparedStatement stmt) 
	{
	    LinkedHashMap<Integer, Employee> employees = new LinkedHashMap<Integer, Employee>();

	    try {
	        ResultSet rs = stmt.executeQuery();
	        int count = 1;

	        while (rs.next()) {
	        	//System.out.println(rs.getString("Name"));
        	    employees.put(count, new Employee(rs.getString("Name"), rs.getString("Email"), rs.getInt("ID"), rs.getInt("Salary")));
	        	//employee = emp(rs.next());
	            //employees.add(employee);
        	    count++;
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }finally{
	    }

	    return employees;
	}
}
