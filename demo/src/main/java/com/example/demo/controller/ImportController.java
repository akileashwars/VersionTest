package com.example.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Branch;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeCard;
import com.example.demo.entity.Product;
import com.example.demo.entity.Town;
import com.example.demo.service.BranchService;
import com.example.demo.service.EmployeeCardService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ProductService;
import com.example.demo.service.TownService;
import com.example.demo.wrapperClass.Branches;
import com.example.demo.wrapperClass.EmployeeCards;
import com.example.demo.wrapperClass.Employees;
import com.example.demo.wrapperClass.Products;
import com.example.demo.wrapperClass.Towns;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
@RequestMapping("/import")
public class ImportController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ProductService productService;

	@Autowired
	BranchService branchService;

	@Autowired
	TownService townService;

	@Autowired
	EmployeeCardService employeeCardService;

	@Autowired
	ResourceLoader resourceLoader;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<String> importEmployees() throws IOException {
		Employee[] readValue = null;
		Resource resource = resourceLoader.getResource("classpath:employees.xml");
		InputStream inputStream = resource.getInputStream();

		// File file2 = new File("F:\\" + file.getOriginalFilename());
		// file2.createNewFile();

		ResponseEntity<String> entity;
		try {
			// FileOutputStream fileOutputStream = new FileOutputStream(file2);
			// fileOutputStream.write(file.getBytes());
			byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
			if (resource.getFile().getAbsolutePath().contains(".xml")) {

				ObjectMapper objectMapper = new XmlMapper();
				// Reads from XML and converts to POJO
				Employees employees = objectMapper.readValue(StringUtils.toEncodedString(bdata, StandardCharsets.UTF_8),
						Employees.class);
				System.out.println(employees.getEmployee());
				readValue = employees.getEmployee();
			} else {
				ObjectMapper mapper = new ObjectMapper();
				readValue = mapper.readValue(bdata, Employee[].class);
				System.out.println(readValue);
			}

			List<Employee> createOrUpdateEmployee = employeeService.createOrUpdateEmployee(readValue);
			if (createOrUpdateEmployee != null) {
				if (createOrUpdateEmployee.size() == 1) {
					entity = new ResponseEntity<String>(
							"Successfully imported Employee{" + createOrUpdateEmployee.get(0).getFirst_Name()
									+ createOrUpdateEmployee.get(0).getLast_Name() + "}",
							HttpStatus.OK);

				} else {
					entity = new ResponseEntity<String>("Successfully imported Employees", HttpStatus.OK);

				}
			} else {
				entity = new ResponseEntity<String>("Invalid  Employees Details", HttpStatus.OK);
			}

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return entity;
	}

	@RequestMapping(value = "/towns", method = RequestMethod.GET)
	public ResponseEntity<String> importTowns() throws IOException

	{

		Town[] readValue = null;
		// File file2 = new File("F:\\" + file.getOriginalFilename());
		// file2.createNewFile();
		Resource resource = resourceLoader.getResource("classpath:towns.xml");
		InputStream inputStream = resource.getInputStream();
		ResponseEntity<String> entity;
		try {
			// FileOutputStream fileOutputStream = new FileOutputStream(file2);
			// fileOutputStream.write(file.getBytes());
			byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
			if (resource.getFile().getAbsolutePath().contains(".xml")) {
				ObjectMapper objectMapper = new XmlMapper();
				// Reads from XML and converts to POJO
				Towns towns = objectMapper.readValue(StringUtils.toEncodedString(bdata, StandardCharsets.UTF_8),
						Towns.class);
				System.out.println(towns.getTown());
				readValue = towns.getTown();
			}

			else {

				ObjectMapper mapper = new ObjectMapper();
				readValue = mapper.readValue(bdata, Town[].class);

			}
			List<Town> createOrUpdateTown = townService.createOrUpdateTown(readValue);

			if (createOrUpdateTown != null) {
				if (createOrUpdateTown.size() == 1) {
					entity = new ResponseEntity<String>(
							"Successfully imported Town{" + createOrUpdateTown.get(0).getName() + "}", HttpStatus.OK);

				} else {
					entity = new ResponseEntity<String>("Successfully imported Towns", HttpStatus.OK);

				}
			} else {
				entity = new ResponseEntity<String>("Invalid  Town Details", HttpStatus.OK);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return entity;

	}

	@RequestMapping(value = "/branches", method = RequestMethod.GET)
	public ResponseEntity<String> importBranches() throws IOException

	{
		Branch[] readValue = null;
		Resource resource = resourceLoader.getResource("classpath:branches.xml");
		InputStream inputStream = resource.getInputStream();
		ResponseEntity<String> entity;
		try {
			byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
			if (resource.getFile().getAbsolutePath().contains(".xml")) {
				ObjectMapper objectMapper = new XmlMapper();
				// Reads from XML and converts to POJO
				Branches branches = objectMapper.readValue(StringUtils.toEncodedString(bdata, StandardCharsets.UTF_8),
						Branches.class);
				System.out.println(branches.getBranch());
				readValue = branches.getBranch();
			}

			else {

				ObjectMapper mapper = new ObjectMapper();
				readValue = mapper.readValue(bdata, Branch[].class);

			}
			List<Branch> createOrUpdateBranch = branchService.createOrUpdateBranch(readValue);

			if (createOrUpdateBranch != null) {
				if (createOrUpdateBranch.size() == 1) {
					entity = new ResponseEntity<String>(
							"Successfully imported Branch{" + createOrUpdateBranch.get(0).getName() + "}",
							HttpStatus.OK);

				} else {
					entity = new ResponseEntity<String>("Successfully imported Branches", HttpStatus.OK);

				}
			} else {
				entity = new ResponseEntity<String>("Invalid  Branch Details", HttpStatus.OK);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

		return entity;

	}

	@RequestMapping(value = "/employeeCards", method = RequestMethod.GET)
	public ResponseEntity<String> importEmployeeCards() throws IOException

	{
		EmployeeCard[] readValue = null;
		Resource resource = resourceLoader.getResource("classpath:employeeCards.xml");
		InputStream inputStream = resource.getInputStream();
		ResponseEntity<String> entity;
		try {
			byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);

			if (resource.getFile().getAbsolutePath().contains(".xml")) {

				ObjectMapper objectMapper = new XmlMapper();
				// Reads from XML and converts to POJO
				EmployeeCards employeeCards = objectMapper
						.readValue(StringUtils.toEncodedString(bdata, StandardCharsets.UTF_8), EmployeeCards.class);
				System.out.println(employeeCards.getEmployeeCard());
				readValue = employeeCards.getEmployeeCard();

			}

			else {

				ObjectMapper mapper = new ObjectMapper();
				readValue = mapper.readValue(bdata, EmployeeCard[].class);

			}
			List<EmployeeCard> createOrUpdateEmployeeCard = employeeCardService.createOrUpdateEmployeeCard(readValue);

			if (createOrUpdateEmployeeCard != null) {
				if (createOrUpdateEmployeeCard.size() == 1) {
					entity = new ResponseEntity<String>(
							"Successfully imported EmployeeCard{" + createOrUpdateEmployeeCard.get(0).getNumber() + "}",
							HttpStatus.OK);

				} else {
					entity = new ResponseEntity<String>("Successfully imported EmployeeCards", HttpStatus.OK);

				}
			} else {
				entity = new ResponseEntity<String>("Invalid  Branch Details", HttpStatus.OK);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			return null;
		}
		return entity;
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<String> importProducts() throws IOException

	{

		Product[] readValue = null;
		Resource resource = resourceLoader.getResource("classpath:products.xml");
		InputStream inputStream = resource.getInputStream();
		ResponseEntity<String> entity;
		try {
			byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);

			if (resource.getFile().getAbsolutePath().contains(".xml")) {

				ObjectMapper objectMapper = new XmlMapper();
				Products products = objectMapper.readValue(StringUtils.toEncodedString(bdata, StandardCharsets.UTF_8),
						Products.class);
				System.out.println(products.getProduct());

			} else {
				ObjectMapper mapper = new ObjectMapper();
				readValue = mapper.readValue(bdata, Product[].class);

			}
			List<Product> createOrUpdateProduct = productService.createOrUpdateProduct(readValue);

			if (createOrUpdateProduct != null) {
				if (createOrUpdateProduct.size() == 1) {
					entity = new ResponseEntity<String>(
							"Successfully imported EmployeeCard{" + createOrUpdateProduct.get(0).getName() + "}",
							HttpStatus.OK);

				} else {
					entity = new ResponseEntity<String>("Successfully imported Products", HttpStatus.OK);

				}
			} else {
				entity = new ResponseEntity<String>("Invalid  Product Details", HttpStatus.OK);
			}
		} catch (Exception e) { // TODO: handle exception e.printStackTrace(); return null;
			return null;
		}
		return entity;

	}

}