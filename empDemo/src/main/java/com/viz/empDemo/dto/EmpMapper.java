package com.viz.empDemo.dto;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.viz.empDemo.entity.Employee;
@Component
public class EmpMapper {

	public Double findTotoalTax(Double totalSalary){
		double totalTax=0.0;
		if(totalSalary<=250000) {
			totalTax=0.0;
		}else if(totalSalary>250000 && totalSalary<=500000) {
			totalTax= (((totalSalary-250000)*5)/100);
		}else if(totalSalary>500000 && totalSalary<=1000000) {
			double betweenFiveLacToTenLacTax= (((totalSalary-500000)*10)/100);
			totalTax=12500.0+betweenFiveLacToTenLacTax;
		}else if(totalSalary>1000000) {
			double aboveTenLacTax= (((totalSalary-1000000)*20)/100);
			totalTax=62500.0+aboveTenLacTax;
		} 
		return totalTax;
	}
	
	public Double findEmployeeSalaryBasedOnDateOfJoining(Date doj,Double totalSalary) {
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		double 	actualSalaryPerYar=0.0;
		try {
			java.util.Date date  = format.parse("2024-05-16");
			if(doj.equals(date) || doj.before(date)) {
				double monthlySal=totalSalary/12;
				double halfMonthSal=monthlySal/2;
				double removableSalary=halfMonthSal+monthlySal;
				actualSalaryPerYar=totalSalary-removableSalary;
			}else {
				actualSalaryPerYar=totalSalary;
				return actualSalaryPerYar;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0.0;
	}
	public Employee convertEmpdtoToEmpEntity(EmpBean empBean){
		String phoneNumbers =convertListOfPhoneToString(empBean.getPhoneNumbers());
		java.sql.Date joiningDate=convertStringDateToSqlDate(empBean.getDoj());
		Employee employee=new Employee(0, empBean.getFirstName(), empBean.getLastName(), empBean.getEmail(), phoneNumbers, joiningDate, empBean.getSalary());
		return employee;
	}
	
	public String convertListOfPhoneToString(List<String> phoneNumbers){
		String allphonenumbers="";
		for (String mobileNumber : phoneNumbers) {
			if(allphonenumbers.isEmpty()) {
				allphonenumbers=mobileNumber;
			}else {
				allphonenumbers=allphonenumbers+","+mobileNumber;
			}
		}
		return allphonenumbers;
	}
	
	public java.sql.Date convertStringDateToSqlDate(String dateOfJoining) {
		java.sql.Date joiningDate=null;
		try {
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date  = format.parse(dateOfJoining);
			joiningDate=new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return joiningDate;
	}
}
