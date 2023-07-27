package com.masai.service;

import java.util.List;

import com.masai.exception.InvalidProductIdException;
import com.masai.model.Product;
import com.masai.model.ProductDTO;

public interface ProductService {
	
	public Product registerProduct(Product p)throws InvalidProductIdException;
	
	public List<Product> getAllProducts()throws InvalidProductIdException;
	
	public Product updateProduct(Product p)throws InvalidProductIdException;
	
	public Product deleteProductById(Integer pid)throws InvalidProductIdException;
	
	public List<Product> getsProductByCategory(String category)throws InvalidProductIdException;
	
	public List<ProductDTO> getProductNameQtyPrice() throws InvalidProductIdException;
}
