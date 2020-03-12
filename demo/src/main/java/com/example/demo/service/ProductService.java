package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
@Autowired
ProductRepository productRepository;

public List<Product> createOrUpdateProduct(Product[] readValue) {
	
List<Product> saveAll = productRepository.saveAll(Arrays.asList(readValue));
return saveAll;
}

List<Product> getProductByTown()
{
	List<Product> product = productRepository.findProductByTown();
	return product;
}


List<Product>getProduct()
{
	
List<Product> findAll = productRepository.findAll();
return findAll;
}


}

