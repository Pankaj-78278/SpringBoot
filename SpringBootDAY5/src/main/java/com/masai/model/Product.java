package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@NotNull(message="product should not be empty")
	@Size(min = 3,max = 5,message= "Product name length should be between min= 3 and max =5 ")
	private String productName;
	
	@NotNull(message="Quantity should not be zero or negative")
	@Min(message="Quantity should not be zero or negative", value = 1)
	private Integer quantity;
	
	@NotNull(message= "price should not be empty")
	private Double price; 
	
	@NotNull(message="category should not be empty ")
	private String category;
	
	public Product(Integer productId, String productName, Integer quantity, Double price, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + ", category=" + category + "]";
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	} 
	
	
	
}
