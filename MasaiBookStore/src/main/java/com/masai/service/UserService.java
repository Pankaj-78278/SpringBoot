package com.masai.service;

import java.util.List;

import com.masai.exception.AuthorException;
import com.masai.exception.BookException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Author;
import com.masai.model.Book;
import com.masai.model.User;
import com.masai.model.UserDTO;

public interface UserService {

	public User registerUser(User user) throws UserException;
	
	public String userLogin(UserDTO dto) throws LoginException;
	
	public Author registerNewAuthor(Author aut) throws AuthorException; 
	
	public Book registerNewBook(Integer bookid, User logInUser) throws BookException;
	
	public Book getBookById(Book book, Integer bookid, String OTP ) throws UserException,BookException;

	public List<Author>  getAuthor(Integer id) throws AuthorException; 
	
	public String purchaseBooks(String uId) throws UserException;
	
	public Author deleteAnAuthor(Author id) throws AuthorException;
}
