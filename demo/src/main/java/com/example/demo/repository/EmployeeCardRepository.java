package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmployeeCard;
@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard,Integer>{

	@Query("select c from EmployeeCard c where c not in (select e.employeeCard  from Employee e)")
	public List<EmployeeCard>findFreeCards();
	

	
}
