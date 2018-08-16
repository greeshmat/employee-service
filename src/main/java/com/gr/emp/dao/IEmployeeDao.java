package com.gr.emp.dao;

import java.util.HashMap;
import com.gr.emp.domain.Employee;

public interface IEmployeeDao {

     public Employee createEmployee(int id, String name);
        
     public Employee retreiveEmployee(int id);
        
     public Employee updateEmployee(int id, String name);

     public void deleteEmployee(int id);
}
