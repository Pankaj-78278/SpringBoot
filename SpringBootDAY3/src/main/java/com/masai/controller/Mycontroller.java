package com.masai.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;

@RestController
@RequestMapping(value = "/bookservice")
public class Mycontroller {
//	Book Id : 101,
//	name: "C++",
//	author: "Nitesh",
//	publication: "Rajput Publication",
//	category: "Computer Programming",
//	pages: 1500,
//	price: 240,
//	author_no : G452
	private List<Book> books= new ArrayList<>();
	
	
	
	
	@PostConstruct
	public void insertBooks(){
	
	books.add(new Book(101,"C++","Nitesh","Rajput Publication","Computer Programming",1500,140,"G452"));
	books.add(new Book(103,"C#","PAnkaj","Rajput Publication","Computer Programming",1800,740,"G452"));
	books.add(new Book(105,"C+","VICKY","Rajput Publication","Computer Programming",1400,340,"G4526"));
	books.add(new Book(107,"JAVA","SANJAY","Rajput Publication","Computer Programming",1200,280,"G252"));
	books.add(new Book(109,"PYTHON","PATIL","Rajput Publication","Computer Programming",500,20,"G457"));
		
//	http://localhost:8888/bookservice/books
	}
	

//	1. Get All books information
//	To get a list of books calls the following endpoint with GET Request.
//	Endpoint: http://localhost:8088/bookservice/books

	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		
		return books;
	}
	
//	2. Get the information of any particular book by id
//	To get a particular book, use the following URL with GET request type in postman
//	Endpoint: http://localhost:8088/bookservice/books/<id>

	
	@GetMapping(value = "/books/{id}")
	public Book getBookById(@PathVariable("id") Integer BookId){
		Book b=null;
		
		for(Book book: books ) {
			if(book.getBookId()==BookId) {
				b=book;
			}
		}
		if(b!=null) {
			return b;
		}else {
			throw new IllegalArgumentException("ID is not found");
		}
//		http://localhost:8888/bookservice/books/103	
	}
	
//3.	Create a new Book
//	To Create New Book use the following URL with the POST Request
//	Endpoint: http://localhost:8088/bookservice/books

	
	@PostMapping("/books")
	public Book createNewBook(@RequestBody Book book) {
		books.add(book);
		
		return book;
	}
	
//	4. Delete Book
//	To delete a particular Book.
//	Endpoint: http://localhost:8080/bookservice/books/<id>
	
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable("id") Integer BookId) {
		
		boolean flag=false;
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getBookId()==BookId) {
				books.remove(i);
				flag=true;
			}
		}
		if(true) {
			return "Delete book by bookID";
		}else {
			throw new IllegalArgumentException("no bookid fiind ");
		}
		
	}
	
	
//	5. Update Book
//	To update a Book, use the following URL with the PUT request type in postman
//	Endpoint: http://localhost:8088/bookservice/books/<id>
	
	
	
	@PutMapping("/books/{id}")
	public Book updateByBookid(@RequestBody Book book , @PathVariable("id") Integer BookId) {
		boolean flag=true;
		
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getBookId()==BookId) {
				Book existingBook= books.get(i);
				
				existingBook.setName(book.getName());
				existingBook.setAuthor(book.getAuthor());
				existingBook.setAuthor_no(book.getAuthor_no());
				existingBook.setCategory(book.getCategory());
				existingBook.setPages(book.getPages());
				existingBook.setPrice(book.getPrice());
				existingBook.setPublication(book.getPublication());
				flag=false;
				return existingBook;
			}
		}
		if(flag) 
			throw new IllegalArgumentException("bookid is not found");
		
		
		return null;
	}
	
	
//	6. Update Book using Request parameter
//	To update a Book price by taking the price with the Request parameter:
//	Endpoint: http://localhost:8088/bookservice/updateprice/<id>?price=500
	
	
	@PutMapping("/books/{id}/{price}")
	public Book updatePriceById(@RequestBody Book book ,
								@PathVariable("id") Integer BookId,
								@RequestParam("price") Integer price) 
	{	
		
		boolean flag=true;
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getBookId()==BookId) {
				
				Book updatePrice = books.get(i);
				
				updatePrice.setPrice(book.getPrice());
				
				flag=false;
				return updatePrice;
			}
		}
		
		if(true) {
			throw new IllegalArgumentException("ID is not found");
		}
		
		
		
		
		return null;
		
		
	}
	
	
}
