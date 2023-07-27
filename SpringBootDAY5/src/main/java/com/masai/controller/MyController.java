package com.masai.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.InvalidProductIdException;
import com.masai.model.Product;
import com.masai.model.ProductDTO;
import com.masai.service.ProductService;

@RestController
public class MyController {
	
	@Autowired
	private ProductService pSer;
	
	@PostMapping("/products")
	public ResponseEntity<Product> insertProduct(@Valid @RequestBody Product product) throws Throwable  {
		Product pro=pSer.registerProduct(product);
		
		return new  ResponseEntity<Product>(pro,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProductDetailHandler(Product product) throws InvalidProductIdException {
		
		List<Product> result =pSer.getAllProducts();
		
		return new ResponseEntity<List<Product>>(result,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/products")
	public ResponseEntity<Product> updateProductDetailHandler(@RequestBody Product p) throws InvalidProductIdException {
		
		Product res=pSer.updateProduct(p);
		
		return new ResponseEntity<Product>(res,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProductById(@PathVariable("id") Integer productId) throws InvalidProductIdException {
		
	 Product res=pSer.deleteProductById(productId);
		
		return new ResponseEntity<Product>(res,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/products/{cate}")
	public ResponseEntity<List<Product>> productByCategory(@PathVariable("cate")  String category) throws InvalidProductIdException {
		
	List<Product> res	=pSer.getsProductByCategory(category);
		
		return new ResponseEntity<List<Product>>(res,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getproductsname")
	public ResponseEntity<List<ProductDTO>> getNameQtyByPrice(ProductDTO productDto) throws InvalidProductIdException {
		List<ProductDTO> res1=pSer.getProductNameQtyPrice();
		
		
		return new ResponseEntity<List<ProductDTO>>(res1,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
