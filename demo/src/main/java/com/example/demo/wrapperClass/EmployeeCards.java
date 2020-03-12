package com.example.demo.wrapperClass;

import java.util.Arrays;

import com.example.demo.entity.EmployeeCard;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "employeeCards")
public class EmployeeCards {
	@JacksonXmlElementWrapper(localName = "employeeCard", useWrapping = false)
	private EmployeeCard[] employeeCard;

	public EmployeeCards() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeCards(EmployeeCard[] employeeCard) {
		this.employeeCard = employeeCard;
	}

	public EmployeeCard[] getEmployeeCard() {
		return employeeCard;
	}

	public void setEmployeeCard(EmployeeCard[] employeeCard) {
		this.employeeCard = employeeCard;
	}

	@Override
	public String toString() {
		return "EmployeeCards{" + "employeeCards=" + Arrays.toString(employeeCard) + '}';
	}
}
