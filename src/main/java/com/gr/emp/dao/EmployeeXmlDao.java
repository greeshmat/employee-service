package com.gr.emp.dao;

import java.util.HashMap;
import com.gr.emp.domain.Employee;
import com.gr.emp.xml.parser.EmployeeXmlParser;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class EmployeeXmlDao implements IEmployeeDao {

	 private EmployeeXmlParser empParser = new EmployeeXmlParser(); 
     private HashMap<Integer, Employee> empMap = new HashMap<Integer, Employee>();
     
     public Employee createEmployee(int id, String name) {
            Employee e1 = new Employee();
            e1.setId(id);
            e1.setName(name);
			Map<Integer, Employee> employees = empParser.readEmployees();
			List<Employee> empList = new ArrayList<Employee>(employees.values());
			empList.add(e1);
            empParser.saveToXML(empList);
			return e1;
        }
        
        public Employee retreiveEmployee(int id) {
            Map<Integer, Employee> employees = empParser.readEmployees();
			return employees.get(id);
        }
        
        public Employee updateEmployee(int id, String name) {
            /*Employee updateEmp = empMap.get(id);
            if(updateEmp!= null) {
                updateEmp.setName(name);
                empMap.put(id, updateEmp);
            }*/
			Map<Integer, Employee> employees = empParser.readEmployees();
			Employee updateEmp = employees.get(id);
			if(updateEmp!= null) {
                updateEmp.setName(name);
				List<Employee> empList = new ArrayList<Employee>(employees.values());
				empList.add(updateEmp);
            	empParser.saveToXML(empList);
			}	
            
            return updateEmp;
        }

        public void deleteEmployee(int id) {
            //empMap.remove(id);
			Map<Integer, Employee> employees = empParser.readEmployees();
			Employee deleteEmp = employees.get(id);	
			List<Employee> empList = new ArrayList<Employee>(employees.values());
			empList.remove(deleteEmp);
            empParser.saveToXML(empList);		
        } 
}
