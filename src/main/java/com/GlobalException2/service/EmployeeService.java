package com.GlobalException2.service;

import java.util.List;

import com.GlobalException2.model.Employee;

public interface EmployeeService {

	  
	  public String createEmployee(Employee employee);
	  public String updataEmployee(Employee employee,int id);
	  public String deleteEmployeeById(int id);
	  public List<Employee> getAllEmployee();
	  public Employee getEmployeeById(int id);
	  public List<Employee> getByName(String name);
	  
}
