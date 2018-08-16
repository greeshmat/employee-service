package com.gr.emp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDbDao {

	public Connection getConnection() {
	
		try {
		Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			

		}

		String url = "jdbc:postgresql://localhost:5432/greeshmadb";
        String user = "postgres";
        String password = "postgres";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException ex) {
				ex.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection() {
		Connection con = null;
		if (con != null) {				
			try {					
				con.close();
			} catch (Exception e){}
		}
	}
}
