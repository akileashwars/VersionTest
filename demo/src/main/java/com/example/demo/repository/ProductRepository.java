package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
@Query("SELECT p FROM Product p INNER JOIN Town t ON p.branch.town = t")
	List<Product> findProductByTown();


}
