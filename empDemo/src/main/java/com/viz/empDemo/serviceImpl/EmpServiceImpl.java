package com.viz.empDemo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viz.empDemo.dto.EmpBean;
import com.viz.empDemo.dto.EmpMapper;
import com.viz.empDemo.dto.EmployeeResponseBean;
import com.viz.empDemo.entity.Employee;
import com.viz.empDemo.exception.DataSourceException;
import com.viz.empDemo.exception.EmpNotEmpty;
import com.viz.empDemo.exception.EmployeeNotFoundException;
import com.viz.empDemo.repository.EmployeeRepository;
import com.viz.empDemo.service.EmpService;
@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	EmpMapper empMapper;
	/**
	 * find emp details by id
	 */
	@Override
	public EmployeeResponseBean findEmployeeDetails(int id) throws EmployeeNotFoundException, Exception {
		EmployeeResponseBean employeeResponseBean=null;
		try {
			Optional<Employee> optionalEmp=empRepository.findById(id);
			Employee emp=optionalEmp.get();
//			emp.getDoj();
			double totalTax=empMapper.findTotoalTax(emp.getSalary());
			double empSalarywithTax=emp.getSalary()-totalTax;
			Double actualSlary=empMapper.findEmployeeSalaryBasedOnDateOfJoining(emp.getDoj(),empSalarywithTax);
			double calculateCessAmount=0.0;
			if(actualSlary>2500000) {
				calculateCessAmount=((actualSlary*2)/100);
				actualSlary=actualSlary-calculateCessAmount;
			}
			employeeResponseBean=new EmployeeResponseBean(emp.getFirstName().substring(0,3), emp.getFirstName(), emp.getLastName(), emp.getEmail(), Math.floor(actualSlary), Math.floor(totalTax), Math.floor(calculateCessAmount));
			return employeeResponseBean;
		}catch(Exception enf) {
			throw new EmployeeNotFoundException("Employee "+id+"not found in the  Data Base");
		}
	}

	/**
	 * save emp details in db
	 */
	@Override
	public Employee saveEmployee(EmpBean empBean) throws EmpNotEmpty,DataSourceException, Exception {

		try {
			Employee empObj=null;
			if(empBean!=null) {
				Employee empEntity=empMapper.convertEmpdtoToEmpEntity(empBean);
				empObj =empRepository.save(empEntity);

			}else {
				throw new EmpNotEmpty("Empty Object Can't Save");
			}
			return empObj;
		}catch(Exception de) {
			throw new DataSourceException("DB connectvity issue");
		}
		
	}

	@Override
	public List<Employee> findAllEmployee() throws EmployeeNotFoundException, Exception {
		
		return empRepository.findAll();
	}
	
	

	
}
