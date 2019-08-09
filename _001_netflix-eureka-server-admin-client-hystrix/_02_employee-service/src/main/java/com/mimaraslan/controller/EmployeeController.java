package com.mimaraslan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mimaraslan.model.Employee;

@RestController
public class EmployeeController {

	private static final Map<Integer, Employee> employeeData = new HashMap<Integer, Employee>() {

		private static final long serialVersionUID = 1L;
		{
			put(1, new Employee(1, "Employee1"));
			put(2, new Employee(2, "Employee2"));
		}
	};

	@RequestMapping(value = "/findEmployeeDetails/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployeeDetails(@PathVariable int employeeId) {

		Employee employee = employeeData.get(employeeId);
		if (employee == null) {
			employee = new Employee(0, "N/A");
		}
		System.out.println("Getting Employee details for " + employeeId);
		return employee;
	}
}