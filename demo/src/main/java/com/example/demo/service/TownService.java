package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customObject.CustomTown;
import com.example.demo.entity.Product;
import com.example.demo.entity.Town;
import com.example.demo.repository.TownRepository;

@Service
public class TownService {
@Autowired
TownRepository repository;
@Autowired
ProductService productService;
public List<Town> createOrUpdateTown(Town[] readValue) {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub

List<Town> saveAll = repository.saveAll(Arrays.asList(readValue));
return saveAll;
}

public List<CustomTown>getTowns()
{
List<Product> product = productService.getProductByTown();	
List<Town>towns=new ArrayList<Town>();
List<CustomTown>customTowns=new ArrayList<CustomTown>();
for (Product product2 : product) {
Town town = product2.getBranch().getTown();	
if (!towns.contains(town)) {
	towns.add(town)	;
	CustomTown customTown=new CustomTown();
	customTown.setName(town.getName());
	customTown.setPopulation(town.getPopulation());
	customTown.setClient(product2.getClients());
    customTowns.add(customTown);
}
else
{
for (CustomTown customTown : customTowns) {
	if (customTown.getName().equalsIgnoreCase(town.getName())) {
		customTown.setClient(customTown.getClient()+product2.getClients());
	}
}	
}
}
Collections.sort(customTowns,new Comparator<CustomTown>() {
	@Override
	public int compare(CustomTown o1, CustomTown o2) {
		// TODO Auto-generated method stub
	CustomTown customTown=	o1;
	CustomTown customTown1= o2;
		
		return customTown.getClient()-customTown1.getClient();
	}
});
return customTowns;
}	
}




