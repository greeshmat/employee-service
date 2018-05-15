package com.gr.emp.service;

import com.gr.emp.domain.Employee;
import com.gr.emp.dao.EmployeeDao;
import java.util.HashMap;


public class EmployeeService {

        public static Employee createEmployee(int id, String name) {
            return EmployeeDao.createEmployee(id, name);
        }
        
        public static Employee retreiveEmployee(int id) {
            return EmployeeDao.retreiveEmployee(id);
        }
        
        public static Employee updateEmployee(int id, String name) {
            return EmployeeDao.updateEmployee(id,name);
        }

        public static void deleteEmployee(int id) {
            EmployeeDao.deleteEmployee(id);
        } 
}
