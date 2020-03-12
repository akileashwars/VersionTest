package com.example.demo.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
@Autowired
EmployeeRepository employeeRepository;

@Transactional
public List<Employee> createOrUpdateEmployee(Employee[] employees)
{
	
	List<Employee> saveAll=null;
	try {
	
		saveAll = employeeRepository.saveAll(Arrays.asList(employees));
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

	return saveAll;
}

public List<Employee>getProductiveEmployees()
{

List<Employee> findProductiveEmployees = employeeRepository.findProductiveEmployees();	
	
Collections.sort(findProductiveEmployees,new Comparator<Employee>() {

@Override
public int compare(Employee e1, Employee e2) {
	// TODO Auto-generated method stub
	String s1=e1.getFirst_Name()+e1.getLast_Name();
	String s2=e2.getFirst_Name()+e2.getLast_Name();
	return s1.compareTo(s2);
}
});

Collections.sort(findProductiveEmployees,new Comparator<Employee>() {

@Override
public int compare(Employee e1, Employee e2) {
	// TODO Auto-generated method stub
	return e1.getPosition().length()-e2.getPosition().length();
}
});
return findProductiveEmployees;	
}

}
