package mvcdemo.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEst {
	//private Connection con = null;
	private static Connection con = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		if(con==null) {
		//Use property file to generate connection to Database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LOGIN?autoReconnect=true&useSSL=false", "kalpit095@localhost", "rupali17331");
		}
		return con;
	}
}
