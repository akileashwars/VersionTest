package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.example.demo.customObject.CustomBranch;
import com.example.demo.customObject.CustomTown;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeCard;

public class ExportFile {

	private String path;

	public ExportFile(String path) {
		this.path = path;

	}

	public boolean processandExportEmployee(List<Employee> employees) {

		String temp = "";
		for (int i = 0; i < employees.size(); i++) {
			Employee e = employees.get(i);
			if (i == 0) {
				temp += e.getFirst_Name() + e.getLast_Name() + "," + e.getPosition() + ","
						+ e.getEmployeeCard().getNumber();
			} else {

				temp += "\n" + e.getFirst_Name() + e.getLast_Name() + "," + e.getPosition() + ","
						+ e.getEmployeeCard().getNumber();

			}

		}

		return export(temp,"employees");

	}

	public boolean processAndexportTown(List<CustomTown> customTowns) {
		String temp = "";
		for (int i = 0; i < customTowns.size(); i++) {
			CustomTown cT = customTowns.get(i);
			if (i == 0) {
				temp += cT.getName() +","+ cT.getPopulation() + "," + cT.getClient();
			} else {

				temp += "\n" + cT.getName() +","+ cT.getPopulation() + "," + cT.getClient();

			}

		}

		return export(temp,"towns");
	}

	public boolean processAndExportFreeCards(List<EmployeeCard> employeeCards) {
	
		String temp = "";
		for (int i = 0; i < employeeCards.size(); i++) {
			EmployeeCard eC = employeeCards.get(i);
			if (i == 0) {
				temp += eC.getId()+","+eC.getNumber();
			} else {

				temp += "\n" + eC.getId()+","+eC.getNumber();

			}

		}

		
		return export(temp,"employeeCards");

	}

	public boolean processAndExportTopBranches(List<CustomBranch> customBranches) {
		
		String temp = "";
		for (int i = 0; i < customBranches.size(); i++) {
			CustomBranch cb = customBranches.get(i);
			if (i == 0) {
				temp += cb.getName() + "," + cb.getTownName() + ","+cb.getTotalClient();
			} else {

				temp += "\n" +cb.getName() + "," + cb.getTownName() + ","+cb.getTotalClient();

			}

		}

		
		return export(temp,"Branches");

	}
	
	
	private boolean export(String string,String fileName)
	{
		
		try {
			@SuppressWarnings("resource")
			FileWriter fileWriter=new FileWriter(new File(this.path+"/"+fileName+".csv"));
			fileWriter.write(string);
			fileWriter.flush();
			fileWriter.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	
	}
	
	

}
