package com.masai.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.InvalidIdException;
import com.masai.model.Book;

@RestController
public class BookController {

	private List<Book> books =new ArrayList<>();

	@PostConstruct
	public void insertBook() {
		books.add(new Book(10,"Pankaj", "Pankaj Publication", 500));
		books.add(new Book(20,"Sumit", "Sumit Publication", 300));
		books.add(new Book(30,"Raj", "Raj Publication", 200));
		books.add(new Book(40,"KAmal", "kamla Publication", 400));
		books.add(new Book(50,"Sonu", "Sonu Publication", 100));
//		C:\Users\Vicky\Desktop\Bus Reservation Pankaj	
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		
		return books;
	}
	
//	@GetMapping("/books")
//	public  List<Book> getBook(Book book){
//		for(int i=0;i<books.size();i++) {
//			if(books.size()==0) {
//				throw new IllegalArgumentException("book list is empty");
//			}
//		}
//		return books;
//	}
	
		
	
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") Integer id) throws InvalidIdException{
		
//		Book b=null;
//		
//		for(Book book:books) {
//			
//			if(book.getId()==id) {
//				b=book;
//			}
//		}
//		if(b!=null) {
//			return b;
//		}else {
//			throw new InvalidIdException("Book id is not found");
//		}
		
//		Optional<Book> opt=books.stream().filter(s -> s.getId()==id).findFirst();
//		if(opt.isPresent()){
//			Book b=opt.get();
//			
//			return b;
//		}else {
//			throw new InvalidIdException("BOOk is not present");
//		}
//		
 
//		return books.stream().filter(s -> s.getId()==id).findFirst().orElseThrow(() -> new InvalidIdException("BOOk id is not preasent"));
		
		
		Optional<Book> opt=books.stream().filter(s ->s.getId()==id).findFirst();
		
		Book book=opt.orElseThrow(() -> new InvalidIdException("your book id is not present"));
		
		return book;
	}
	
	
	
	
	@DeleteMapping("/books/{id}")
	public String DeleteByBookId(@PathVariable("id") Integer id) throws InvalidIdException {
	
		boolean flag=false;
		for(int i=0; i<books.size();i++) {
			if(books.get(i).getId()==id) {
				books.remove(i);
				flag=true;
			}
		}
		if(flag) {
			return ("Your book detail deleted");
		}else {
			throw new InvalidIdException("Book ID is not found how may i get deleted pagle shi dalo bookid");
		}
		
		
//		Optional<Book> opt=books.stream().filter(s ->s.getId()==id).findFirst();
//		Book book=opt.orElseThrow(() -> new InvalidIdException("your book id is not present"));
		
		
	}
	
	
	@PostMapping("/books")
	public Book createBookDetail(@RequestBody Book book) {
	
		books.add(book);
		
		return book;
	}
	
	
	
	@PutMapping("/books/{id}")
	public Book UpdateById(@RequestBody Book book,@PathVariable("id") Integer id) throws InvalidIdException {
		
		boolean flag=false;
		
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getId()==id) {
			Book existingBook = books.get(i);
				
				existingBook.setName(book.getName());
				existingBook.setAuthor(book.getAuthor());
				existingBook.setPrice(book.getPrice());
				flag=true;
				return existingBook;
			}
		}
		
		if(!flag) {
			throw new InvalidIdException("Boook ID does not exist");
		}
		
		return null; 
	}
	
	
}
