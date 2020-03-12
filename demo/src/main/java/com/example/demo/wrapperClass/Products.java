package com.example.demo.wrapperClass;

import java.util.Arrays;

import com.example.demo.entity.Product;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "products")
public class Products {

	@JacksonXmlElementWrapper(localName = "product", useWrapping = false)
	private Product[] product;

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(Product[] product) {
		this.product = product;
	}

	public Product[] getProduct() {
		return product;
	}

	public void setProduct(Product[] product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Products{" + "products=" + Arrays.toString(product) + '}';
	}
	
}
