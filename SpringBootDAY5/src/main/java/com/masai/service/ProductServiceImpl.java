package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.masai.dao.ProductRepo;
import com.masai.exception.InvalidProductIdException;
import com.masai.model.Product;
import com.masai.model.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo pRepo; 
	
	
	@Override
	public Product registerProduct(Product p) throws InvalidProductIdException {
		
	Product saveproduct=pRepo.save(p);
		
	return saveproduct;
		
	}

	@Override
	public List<Product> getAllProducts() throws InvalidProductIdException {
		
		List<Product> prod=pRepo.findAll();
		
		if(prod.size()==0) {
			throw new InvalidProductIdException("ProductDetail is Empty");
		}else {
			return prod;
		}
	}

	@Override
	public Product updateProduct(Product p) throws InvalidProductIdException {
		
		Optional<Product> upd=pRepo.findById(p.getProductId());
		
		if(upd.isPresent()) {
				Product prod= pRepo.save(p);
				return prod;
		}else {
			throw new InvalidProductIdException("ProductDetail is Empty");
		}
		
		
		
		
		
		
		
	}

	@Override
	public Product deleteProductById(Integer pid) throws InvalidProductIdException {
		
		Optional<Product> Del=pRepo.findById(pid);
		
		if(Del.isPresent()) {
			Product prod= Del.get();
			
			pRepo.delete(prod);
			
			return prod;
		}else {
			throw new InvalidProductIdException("Product id is not present:");
		}	
	}
	
	

	@Override
	public List<Product> getsProductByCategory(String category) throws InvalidProductIdException {
		List<Product> res=pRepo.findByCategory(category);
		
		if(res.isEmpty()) {
			throw new InvalidProductIdException("Product is empty"+category);
		}else {
			return res;
		}
	}

	
	
	
	
	
//	@Override
//	public List<ProductDTO> getProductNameQtyPrice() throws InvalidProductIdException {
//		List<ProductDTO> name=pRepo.getProductNameQtyByPrice();
//		
//		
//
//	}

//	@Override
//	public List<ProductDTO> getProductNameQtyPrice(String category) throws InvalidProductIdException {
//		List<ProductDTO> name = pRepo.getProductNameQtyByPrice(category);
//		
//		if(name.size()==0) {
//			throw new InvalidProductIdException("Prodcut id is not foiund");
//			
//		}else {
//			return name;
//		}
//	}

	@Override
	public List<ProductDTO> getProductNameQtyPrice() throws InvalidProductIdException {
		
		List<ProductDTO> prod=pRepo.getProductNameQtyByPrice();
		
		if(prod!=null) {
			return prod;
		}else {
			throw new InvalidProductIdException("product id is not valid");
		}
		
		
	}
}
