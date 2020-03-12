package com.example.demo.wrapperClass;

import java.util.Arrays;

import com.example.demo.entity.Branch;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "branches")
public class Branches {
	 @JacksonXmlElementWrapper(localName = "branch", useWrapping = false)
	    private Branch[] branch;
	     public Branches() {
			// TODO Auto-generated constructor stub
		}
	    public Branches(Branch[] branch) {
	        this.branch = branch;
	    }
	    public Branch[] getBranch() {
	        return branch;
	    }
	    public void setBranch(Branch[] branch) {
	        this.branch = branch;
	    }
	    @Override public String toString() {
	        return "Branches{" +
	                "Branches=" + Arrays.toString(branch) +
	                '}';
}
}