package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@Entity
@Table
@JacksonXmlRootElement
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty
	private int id;
	@Column
	@JacksonXmlProperty
	@NotNull
	private String first_Name;
	@Column
	@JacksonXmlProperty
	@NotNull
	private String last_Name;
	@Column
	@JacksonXmlProperty
	@NotNull
	private String position;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "empcard_id",unique=true)
	@JacksonXmlProperty
	@NotNull
	private EmployeeCard employeeCard;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_id")
	@JacksonXmlProperty
	@NotNull
	private Branch branch;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public EmployeeCard getEmployeeCard() {
		return employeeCard;
	}

	public void setEmployeeCard(EmployeeCard emPloyeeCard) {
		this.employeeCard = emPloyeeCard;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
