package com.viz.empDemo.service;



import com.viz.empDemo.dto.EmpBean;
import com.viz.empDemo.dto.EmployeeResponseBean;
import com.viz.empDemo.entity.Employee;
import com.viz.empDemo.exception.DataSourceException;
import com.viz.empDemo.exception.EmpNotEmpty;
import com.viz.empDemo.exception.EmployeeNotFoundException;

public interface EmpService {

	public Employee saveEmployee(EmpBean empBean)throws EmpNotEmpty,DataSourceException,Exception;
	public EmployeeResponseBean findEmployeeDetails(int id) throws EmployeeNotFoundException,Exception;
}
