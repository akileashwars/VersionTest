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
public class Branch implements Serializable{
	

	private static final long serialVersionUID = -5703385301251878067L;
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JacksonXmlProperty
	private int id;
	@Column
	@JacksonXmlProperty
	@NotNull
    private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "town_id")
	@JacksonXmlProperty
	@NotNull
    private Town town;
	
	public Town getTown() {
		return town;
	}
	public void setTown(Town town) {
		this.town = town;
	}
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
	
	

}
