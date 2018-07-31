package com.gr.emp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.gr.emp.domain.Employee;
import com.gr.emp.dao.ConnectionDbDao;

public class EmployeeDbDao implements IEmployeeDao {
	
	ConnectionDbDao connection = new ConnectionDbDao();
	
	public Employee createEmployee(int id, String name) {
		
		Employee e1 = new Employee();
		Connection con= null;
		try {
    		con = connection.getConnection();		
			PreparedStatement pStmt = con.prepareStatement("INSERT INTO employee (ID, NAME, TYPE) VALUES (?,?,?)");
			pStmt.setInt(1, id);
			pStmt.setString(2, name);
			pStmt.setString(3, "Part time");
						
			pStmt.executeUpdate();
		
			e1 = retreiveEmployee(id);			
		} catch (SQLException ex) {
				ex.printStackTrace();
		  } 
		connection.closeConnection();
		return e1;
	}

	 public Employee retreiveEmployee(int id) {
		
		Employee e1 = null;	
		Connection con= null;
		try {
			con = connection.getConnection();                                           
			PreparedStatement pStmt=con.prepareStatement("SELECT ID, NAME FROM employee WHERE ID=?"); 
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				e1 = new Employee();
				int empId = rs.getInt("ID");
				String empName = rs.getString("NAME");				
				e1.setId(empId);
				e1.setName(empName);
			}
        } catch (SQLException ex) {
				ex.printStackTrace();
		  }  
		connection.closeConnection();
		return e1;
	}

	 public Employee updateEmployee(int id, String name) {

		Employee e1 = new Employee();			
		Connection con= null;
		try {
		 	con = connection.getConnection();
		 	PreparedStatement pStmt=con.prepareStatement("UPDATE employee SET NAME=? WHERE ID=?");  
			pStmt.setString(1, name);
			pStmt.setInt(2, id);
			
			pStmt.executeUpdate(); 
 
			e1 = retreiveEmployee(id);
			
		} catch (SQLException ex) {
				ex.printStackTrace();
		  }  
		connection.closeConnection();
		return e1;
	}

	 public void deleteEmployee(int id) {	
	
		Connection con= null;
		try {
			con = connection.getConnection();
			PreparedStatement pStmt=con.prepareStatement("DELETE FROM employee WHERE ID=?");
			pStmt.setInt(1,id);
			 
			pStmt.executeUpdate();  			

		} catch (SQLException ex) {
				ex.printStackTrace();
		  }  
		connection.closeConnection();
	}

}
