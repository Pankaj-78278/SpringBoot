package com.masai.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Product;
import com.masai.model.ProductDTO;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	public List<Product> findByCategory(String category);
	
	@Query("select new com.masai.model.ProductDTO(s.productName,s.quantity,s.price) from Product s") 
	public List<ProductDTO> getProductNameQtyByPrice();

}
