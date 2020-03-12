package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ExportFile;
import com.example.demo.customObject.CustomBranch;
import com.example.demo.customObject.CustomTown;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeCard;
import com.example.demo.service.BranchService;
import com.example.demo.service.EmployeeCardService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.TownService;

@RestController
@RequestMapping("/export")
public class ExportController {
	private String path = "C:/Users/AKILEASHWAR/Desktop";

	@Autowired
	EmployeeCardService employeeCardService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	TownService townService;

	@Autowired
	BranchService branchService;

	@RequestMapping("/free-cards")
	ResponseEntity<String> freeCards() {
		List<EmployeeCard> freeCards = employeeCardService.getFreeCards();

		ResponseEntity<String> entity;

		ExportFile exportFile = new ExportFile(path);
		if(exportFile.processAndExportFreeCards(freeCards))
		{
	entity=	new ResponseEntity<>("Successfully Exported", HttpStatus.OK);
		}
		else
		{
			
			entity=	new ResponseEntity<>("failed", HttpStatus.EXPECTATION_FAILED);
		}
		return entity;

	}

	@RequestMapping("/productive-employees")
	ResponseEntity<String> productiveEmployees() {
		List<Employee> productiveEmployees = employeeService.getProductiveEmployees();
		// File file = new File(home+"/Downloads/" + fileName + ".txt");
		ResponseEntity<String> entity;

		ExportFile exportFile = new ExportFile(path);
		if(exportFile.processandExportEmployee(productiveEmployees))
		{
	entity=	new ResponseEntity<>("Successfully Exported", HttpStatus.OK);
		}
		else
		{
			
			entity=	new ResponseEntity<>("failed", HttpStatus.EXPECTATION_FAILED);
		}
		return entity;

	}

	@RequestMapping("/towns")
	ResponseEntity<String> getTowns() {
		List<CustomTown> towns = townService.getTowns();
		ResponseEntity<String> entity;

		ExportFile exportFile = new ExportFile(path);
		if(exportFile.processAndexportTown(towns))
		{
	entity=	new ResponseEntity<>("Successfully Exported", HttpStatus.OK);
		}
		else
		{
			
			entity=	new ResponseEntity<>("failed", HttpStatus.EXPECTATION_FAILED);
		}
		return entity;

	}

	@RequestMapping("/top-branches")
	ResponseEntity<String> topBranches() {
		List<CustomBranch> topBranches = branchService.getTopBranches();
		ResponseEntity<String> entity;

		ExportFile exportFile = new ExportFile(path);
		if(exportFile.processAndExportTopBranches(topBranches))
		{
	entity=	new ResponseEntity<>("Successfully Exported", HttpStatus.OK);
		}
		else
		{
			
			entity=	new ResponseEntity<>("failed", HttpStatus.EXPECTATION_FAILED);
		}
		return entity;

	}

}
