package com.viz.empDemo.dto;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
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
	
	public Double findEmployeeSalaryBasedOnDateOfJoining(Date doj,Double totalSalary) throws ParseException {
		
		double 	actualSalaryPerYar=0.0;
		LocalDate financialStartDate=LocalDate.of(2024,04,01);
		LocalDate dojInLocalDate=doj.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Long noOfMonths= ChronoUnit.MONTHS.between(financialStartDate,dojInLocalDate);
		Long remaningDays=ChronoUnit.DAYS.between(financialStartDate.plusMonths(noOfMonths),dojInLocalDate);
		double monthlySal=totalSalary/12;
		double daySal=monthlySal/30;
		
		double removableMonthsSal=noOfMonths*monthlySal;
		double removableDaySal=remaningDays*daySal;
		double totalRemovableSal=removableMonthsSal+removableDaySal;
		
		actualSalaryPerYar=totalSalary-totalRemovableSal;
		return actualSalaryPerYar;
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
