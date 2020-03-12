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
public class Product implements Serializable{
    
	private static final long serialVersionUID = 6418715269791477646L;
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@JacksonXmlProperty
	private int id;
	@Column
	@JacksonXmlProperty
	@NotNull
	private String name;
	@Column
	@JacksonXmlProperty
	@NotNull
	private int clients;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClients() {
		return clients;
	}
	public void setClients(int clients) {
		this.clients = clients;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	
	
}
