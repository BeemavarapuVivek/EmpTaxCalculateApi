package com.viz.empDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viz.empDemo.dto.EmpBean;
import com.viz.empDemo.dto.EmployeeResponseBean;
import com.viz.empDemo.entity.Employee;
import com.viz.empDemo.exception.DataSourceException;
import com.viz.empDemo.exception.EmpNotEmpty;
import com.viz.empDemo.exception.EmployeeNotFoundException;
import com.viz.empDemo.service.EmpService;

@RestController
@RequestMapping("/api/emp")
public class EmpController {

	@Autowired
	EmpService empService;
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<EmployeeResponseBean> findEmployee(@PathVariable("id") int empId) throws EmployeeNotFoundException, Exception {
		System.out.println("find emp details::");
		return ResponseEntity.ok(empService.findEmployeeDetails(empId));
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Employee>> findAllEmployee() throws EmployeeNotFoundException, Exception {
		System.out.println("find emp details::");
		return ResponseEntity.ok(empService.findAllEmployee());
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody EmpBean empBean) throws EmpNotEmpty,DataSourceException, Exception {
		return ResponseEntity.ok(empService.saveEmployee(empBean));
	}
}
