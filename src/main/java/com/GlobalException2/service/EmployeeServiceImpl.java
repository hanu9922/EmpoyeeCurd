package com.GlobalException2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GlobalException2.Exception.NoResourceFoundException;
import com.GlobalException2.dao.EmployeeDao;
import com.GlobalException2.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public String createEmployee(Employee employee) {
		
		employeeDao.save(employee);
		return "Employee Saved Successfully";
	}
     
	@Override
	public String updataEmployee(Employee employee,int id) {
		Optional<Employee> emp=employeeDao.findById(id) ;
		
		
		if(!emp.isEmpty()) {
			Employee employee2 = emp.get();
			employee2.setName(employee.getName());
			employee2.setLastName(employee.getLastName());
			employee2.setEmail(employee.getCity());
			employee2.setPhoneNumber(employee.getPhoneNumber());
			employee2.setAge(employee.getAge());
			employee2.setCity(employee.getCity());
			employee2.setState(employee.getState());
		employeeDao.save(employee2);
		return "Employee update sucessfully";
	}
		else
		{
			return "Employee id not present";
		}
	}
	@Override
	public String deleteEmployeeById(int id) {
		employeeDao.deleteById(id);
		return "employee deleted sucessfully";
	}
    
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list = employeeDao.findAll();
		return list;
	}
      
	@Override
	public Employee getEmployeeById(int id) {
		return employeeDao.findById(id).orElseThrow(() -> new NoResourceFoundException("Given id not present in database"));
	}

	@Override
	public List<Employee> getByName(String name) {
		return employeeDao.getEmployeeByName(name);
	}
}
