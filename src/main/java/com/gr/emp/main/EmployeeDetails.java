package com.gr.emp.main;

import java.util.*;
import com.gr.emp.domain.Employee;

public class EmployeeDetails {
        
        private static Employee createEmployee(int id, String name) {
            Employee e1 = new Employee();
                e1.setId(id);
                e1.setName(name);
                return e1;
        }
        
        private static Employee retreiveEmployee(int id, HashMap<Integer, Employee> empMap) {
            return empMap.get(id);
        }
        
        private static Employee updateEmployee(int id, HashMap<Integer, Employee> empMap, String name) {
            Employee updateEmp = empMap.get(id);
            updateEmp.setName(name);
            empMap.put(id, updateEmp);
            return updateEmp;
        }

        private static void deleteEmployee(int id, HashMap<Integer, Employee> empMap) {
            empMap.remove(id);
        } 
        
    public static void main(String args[]) {
    
        System.out.println("\n      ***Menu***\n");
        System.out.println("1. Create Employee");
        System.out.println("2. Retreive Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit\n");
        
        HashMap<Integer, Employee> empMap = new HashMap<Integer, Employee>();
        
        Scanner s = new Scanner(System.in);
        System.out.println("Please select your option");
        int n=0;
        while(n >= 0){
        
            n = s.nextInt();
            switch(n) {
            case 1: System.out.println("Enter Employee id");
                    int i = s.nextInt();
                    s.nextLine();
                    System.out.println("Enter Employee name");
                    String name = s.nextLine();
                    
                    
                    System.out.println("Creating Employee..");
                    Employee emp = createEmployee(i,name);
                    empMap.put(i, emp);
                    System.out.println("Employee created successfully");
                    System.out.println("Please select your next option");
                    break;
        
            case 2: System.out.println("Retreiving Employee..");
                    System.out.println("Which Employee would you like to retreive?");
                    int idToSearch = s.nextInt();
                    Employee searchEmp = retreiveEmployee(idToSearch, empMap);
                    if(searchEmp == null) { 
                        System.out.println("Employee not found for id "+idToSearch);
                    }else {
                        System.out.println("Employee id is "+searchEmp.getId()+" and employee name is "+searchEmp.getName());
                    }
                    
                    
                    System.out.println("Please select your next option");
                    break;
        
            case 3: System.out.println("Updating Employee..");
                    System.out.println("Which Employee details would you like to update?");
                    int idToUpdate = s.nextInt();
                    s.nextLine();
                    System.out.println("Now modify the Employee name");
                    String updatedName = s.nextLine();
                    Employee updateEmp = updateEmployee(idToUpdate, empMap, updatedName);
                    System.out.println("Employee modified successfully");
                    System.out.println("Please select your next option");
                    break;
        
            case 4: System.out.println("deleting Employee..");
                    System.out.println("Which Employee woukd you like to delete?");
                    int idToDelete = s.nextInt();
                    deleteEmployee(idToDelete, empMap);
                    System.out.println("Employee deleted successfully");
                    System.out.println("Please select your next option");
                    break;
            
            case 5: System.out.println("Exitting\n");
                    System.exit(0);
        
            default:System.out.println("Invalid option selected");  
                    System.out.println("Please select your next option");         
        
            }
        
        } 
        s.close();  
            
    }
    
}
