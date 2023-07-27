package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AuthorException;
import com.masai.exception.BookException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Author;
import com.masai.model.Book;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.service.UserService;

@RestController
@RequestMapping("/masaibook")
public class UserController {
	
	@Autowired
	private UserService userv;

	
	@PostMapping("/user/login")
    public ResponseEntity<String> logInUser(@RequestBody UserDTO dto) throws LoginException {
		
        String result = userv.userLogin(dto);
        
        return new ResponseEntity<String>(result, HttpStatus.OK );
      
    }
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException{
		User savesUser=userv.registerUser(user);
		
		return new ResponseEntity<User>(savesUser,HttpStatus.CREATED);
	}
	
	
	 @PostMapping("register/author/book")
	    public ResponseEntity<Author> saveAuthor(@RequestBody Author aut)throws AuthorException {
	        Author author= userv.getAuthor(aut);
	        return new ResponseEntity<Author>(author, HttpStatus.OK);
	    }
	 
	    @PutMapping("/user/cart/{bookId}")
	    public ResponseEntity<Book> addBookId(@RequestBody Book book, @PathVariable Integer bookId, @RequestParam(required = false) String userOTP) throws  BookException, UserException {
	        Book sbook = userv.getBookById(book,bookId,userOTP);
	        return new ResponseEntity<Book>(sbook, HttpStatus.CREATED);
	    }
	    @GetMapping("/author")
		public ResponseEntity<List<Author>> getAllAuthorHandler(@RequestParam Integer authorid) throws AuthorException{
			List<Author> productList =userv.getAuthor(authorid);
			return new ResponseEntity<List<Author>>(productList,HttpStatus.OK);
		}
	    @PutMapping("/register/user/cart/purchase")
		public ResponseEntity<String> purchaseNewBookHandler(@RequestParam  Integer userid, @RequestBody User loggedInUser) throws UserException, LoginException{
			
			String n =  userv.purchaseBooks(userid,loggedInUser);
			
			return new ResponseEntity<String>(n,HttpStatus.CREATED);
		}
	    
	    @DeleteMapping("/author/{authorid}")
	    public ResponseEntity<Author> deleteAuthorHandler(@RequestParam  Integer authorid) throws AuthorException {

	        return new ResponseEntity<Author>(userv.deleteAnAuthor(authorid), HttpStatus.OK);
	    }
	    
}
