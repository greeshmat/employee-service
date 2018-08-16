package com.gr.emp.service;

import com.gr.emp.domain.Employee;
import com.gr.emp.dao.IEmployeeDao;
import java.util.HashMap;


public class EmployeeService {

        private IEmployeeDao empDao;

        public EmployeeService(IEmployeeDao empDao) {
            this.empDao = empDao;
        }

        public Employee createEmployee(int id, String name) {
            return this.empDao.createEmployee(id, name);
        }
        
        public Employee retreiveEmployee(int id) {
            return this.empDao.retreiveEmployee(id);
        }
        
        public Employee updateEmployee(int id, String name) {
            return this.empDao.updateEmployee(id,name);
        }

        public void deleteEmployee(int id) {
            this.empDao.deleteEmployee(id);
        } 
}
