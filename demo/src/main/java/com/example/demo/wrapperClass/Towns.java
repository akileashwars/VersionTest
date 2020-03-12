package com.example.demo.wrapperClass;

import java.util.Arrays;

import com.example.demo.entity.Town;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "towns")
public class Towns {
	@JacksonXmlElementWrapper(localName = "town", useWrapping = false)
	private Town[] town;

	public Towns() {
		// TODO Auto-generated constructor stub
	}

	public Towns(Town[] town) {
		this.town = town;
	}

	public Town[] getTown() {
		return town;
	}

	public void setTown(Town[] town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "Towns{" + "Towns=" + Arrays.toString(town) + '}';
	}
	
}
