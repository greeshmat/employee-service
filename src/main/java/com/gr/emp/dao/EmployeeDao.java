package com.gr.emp.dao;

import java.util.HashMap;
import com.gr.emp.domain.Employee;

public class EmployeeDao implements IEmployeeDao {

     private HashMap<Integer, Employee> empMap = new HashMap<Integer, Employee>();
     
     public Employee createEmployee(int id, String name) {
            Employee e1 = new Employee();
                e1.setId(id);
                e1.setName(name);
                empMap.put(id, e1);
                return e1;
        }
        
        public Employee retreiveEmployee(int id) {
            return empMap.get(id);
        }
        
        public Employee updateEmployee(int id, String name) {
            Employee updateEmp = empMap.get(id);
            if(updateEmp!= null) {
                updateEmp.setName(name);
                empMap.put(id, updateEmp);
            }
            
            return updateEmp;
        }

        public void deleteEmployee(int id) {
            empMap.remove(id);
        } 
}
