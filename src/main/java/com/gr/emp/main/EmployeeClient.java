package com.gr.emp.main;

import java.util.Scanner;
import com.gr.emp.domain.Employee;
import com.gr.emp.service.EmployeeService;

public class EmployeeClient {
             
    public static void main(String args[]) {
    
        System.out.println("\n      ***Menu***\n");
        System.out.println("1. Create Employee");
        System.out.println("2. Retreive Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit\n");
              
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
                    Employee emp = EmployeeService.createEmployee(i,name);
                    System.out.println("Employee created successfully");
                    System.out.println("Please select your next option");
                    break;
        
            case 2: System.out.println("Retreiving Employee..");
                    System.out.println("Which Employee would you like to retreive?");
                    int idToSearch = s.nextInt();
                    Employee searchEmp = EmployeeService.retreiveEmployee(idToSearch);
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
                    Employee updateEmp = EmployeeService.updateEmployee(idToUpdate, updatedName);
                    if(updateEmp == null) {
                        System.out.println("Invalid id entered");
                    } 
                    else {
                        System.out.println("Employee modified successfully");
                    }  
                    System.out.println("Please select your next option");
                    break;
        
            case 4: System.out.println("deleting Employee..");
                    System.out.println("Which Employee woukd you like to delete?");
                    int idToDelete = s.nextInt();
                    EmployeeService.deleteEmployee(idToDelete);
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
