package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

@Query("select e from Employee e where e.branch in (select p.branch  from Product p)")	
	List<Employee> findProductiveEmployees();

}
