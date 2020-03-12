package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Entity
@Table
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Town implements Serializable{

private static final long serialVersionUID = -7953012581604341362L;
@Column
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
@JacksonXmlProperty
private int	id;
@Column
@JacksonXmlProperty
@NotNull
private String name;
@Column
@JacksonXmlProperty
@NotNull
private	int population;
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
public int getPopulation() {
	return population;
}
public void setPopulation(int population) {
	this.population = population;
}

}
