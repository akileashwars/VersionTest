package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customObject.CustomBranch;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Product;
import com.example.demo.repository.BranchRepository;

@Service
public class BranchService {
@Autowired
BranchRepository branchRepository;

@Autowired
ProductService productService;

public List<Branch> createOrUpdateBranch(Branch[] readValue) {
	// TODO Auto-generated method stub

List<Branch> saveAll = branchRepository.saveAll(Arrays.asList(readValue));
return saveAll;
	
}

public List<CustomBranch> getTopBranches()
{
	List<Product> product = productService.getProduct();
	List<CustomBranch>branches=new ArrayList<CustomBranch>();
	List<Branch>branches2=new ArrayList<Branch>();
	for (Product product2 : product) {
		
		if (!branches2.contains(product2.getBranch())) {
			branches2.add(product2.getBranch());
			CustomBranch branch=new CustomBranch();
			branch.setName(product2.getBranch().getName());
			branch.setTownName(product2.getBranch().getTown().getName());
			branch.setTotalClient(product2.getClients());
			branches.add(branch);
		}
		else
		{		
			for (CustomBranch customBranch : branches) {			
			if (customBranch.getName().equalsIgnoreCase(product2.getBranch().getName())) {			
				customBranch.setTotalClient(customBranch.getTotalClient()+product2.getClients());
			}	
				
			}
			
			
		}
	
		
	}
	Collections.sort(branches,new Comparator<CustomBranch>() {
	
	
	@Override
	public int compare(CustomBranch o1, CustomBranch o2) {
		// TODO Auto-generated method stub
		return o1.getTotalClient()-o2.getTotalClient();
	}
	
	});
	
	
	return branches;

}
	
}
