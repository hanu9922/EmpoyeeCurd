package com.GlobalException2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GlobalException2.model.Employee;
import com.GlobalException2.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")  //http://localhost:8080/employee/save
	public String addEmployee(@RequestBody Employee employee ) {
		return employeeService.createEmployee(employee);
		
	}
	@PutMapping("/update/{id}")  //http://localhost:8080/employee/update/1
	public String updateEmployee(@PathVariable int id,@RequestBody Employee employee ) {
		return employeeService.updataEmployee(employee, id);
	}
	@DeleteMapping("/delete/{id}")  //http://localhost:8080/employee/update/1
	public String deleteEmployee(@PathVariable int id ) {
		return employeeService.deleteEmployeeById(id);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployeeData(){
		return employeeService.getAllEmployee();
		
	}
	@GetMapping("/getById/{id}")
	public Employee getAllEmployeeById(@PathVariable int id){
		return employeeService.getEmployeeById(id);
		
	}
	
	@GetMapping("/getEmployeeByName/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name){
		return employeeService.getByName(name);
}

}



