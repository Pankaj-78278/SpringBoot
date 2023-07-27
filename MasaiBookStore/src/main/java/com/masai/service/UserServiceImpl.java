package com.masai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AuthorException;
import com.masai.exception.BookException;
import com.masai.exception.LoginException;
import com.masai.exception.UserException;
import com.masai.model.Author;
import com.masai.model.Book;
import com.masai.model.Cart;
import com.masai.model.CurrentSessionDTO;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.repository.AuthorRepo;
import com.masai.repository.BookRepo;
import com.masai.repository.CartRepo;
import com.masai.repository.SessionRepo;
import com.masai.repository.UserRepo;
import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo urepo;
	
	@Autowired
	private SessionRepo srepo;
	
	@Autowired
	private CartRepo crepo;
	
	@Autowired
	private AuthorRepo arepo;
	
	@Autowired
	private BookRepo brepo;
	
	

	@Override
	public User registerUser(User us) throws UserException {
		User regist = urepo.findByMobileNumber(us.getMobileNumber());
        if (regist != null)
            throw new UserException("user register in Masai Book Store");

        us.setFirstName(us.getFirstName());
        us.setLastName(us.getLastName());
        us.setMobileNumber(us.getMobileNumber());
        us.setAddress(us.getAddress());
        us.setAge(us.getAge());
        us.setGender(us.getGender());
        us.setPassword(us.getPassword());
        us.setBudget(us.getBudget());
        User newUser=urepo.save(us);
        
        
        Cart cart = new Cart();
		cart.setUser(newUser);
		cart.setTotal(0);
		
		crepo.save(cart);

        return newUser;
	}

	@Override
	public String userLogin(UserDTO dto) throws LoginException {
		User UserRepo= urepo.findByMobileNumber(dto.getMobileNumber());
        if(UserRepo == null) {
            throw new LoginException("Please Enter a MobileNumber of User");
        }

        Optional<CurrentSessionDTO> validSessionOpt =  srepo.findById(UserRepo.getUserId());
        if(validSessionOpt.isPresent()) {
            throw new LoginException("Consumer already LoggedIn  ");
        }

        if(UserRepo.getPassword().equals(dto.getPassword())) {

            String userOTP= RandomString.make(4);

            CurrentSessionDTO currentSession = new CurrentSessionDTO(UserRepo.getUserId(),userOTP, LocalDateTime.now());

            srepo.save(currentSession);

            return currentSession.toString();
        }
        else
            throw new LoginException("Please Enter a valid Credentail");
	}

	@Override
	public Author registerNewAuthor(Author aut) throws AuthorException {
		
		Author existAuthor = arepo.findByMobileNumber(aut.getMobileNum());
        
		if (existAuthor != null)
            throw new AuthorException("Author Already registered with mobile :-" + aut.getMobileNum());
        aut.setMobileNum(aut.getMobileNum());
        aut.setAddress(aut.getAddress());


        Author newAut=arepo.save(aut);
        
		Book book = new Book();
		book.setAuthor(newAut);
		
		brepo.save(book);
	
        return newAut;
	}

	@Override
	public Book registerNewBook(Integer bookid, User logInUser) throws BookException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBookById(Book book, Integer bookid, String OTP) throws UserException, BookException {
		 CurrentSessionDTO eu = srepo.findByUuid(OTP);
	        if (eu == null)
	            throw new UserException("User not log in the system ");

	        Book existingbook= brepo.findByBookId(bookid);

	        if(existingbook==null){
	            book.setName(book.getName());
	            book.setAuthor(book.getAuthor());
	            book.setPages(book.getPages());
	            book.setPublisher(book.getPublisher());
	            book.setPrice(book.getPrice());

	            return brepo.save(book);

	        }else
	             throw new BookException("Book are  present Already");
	}

	@Override
	public List<Author> getAuthor(Integer id) throws AuthorException {
		List<Author> list = arepo.findAll();

		if (list.size()==0)
			throw new AuthorException("Author Not Found");

		return list;
	}

	@Override
	public String purchaseBooks(String uId) throws UserException {
		CurrentSessionDTO cs= srepo.findByUuid(uId);
        if(cs!=null) {
            Optional<User> ut = urepo.findById(cs.getId());

            User eU = ut.get();
            Cart uC = eU.getCart();

            List<Book> books = uC.getBooks();

            if(books.size()==0) {
                throw new UserException(" book no present in user's cart");
            }

            while(books.size()>0) {
                Optional<Book> bookOpt = brepo.findById(books.get(0).getBookid());

                Book existingBook = bookOpt.get();

                books.remove(0);

                brepo.delete(existingBook);
            }

            return "book Complete.";
        }
        else{
            throw new UserException("User is  logged out ");
        }
	}

	@Override
	public Author deleteAnAuthor(Author id) throws AuthorException {
		Optional<Author> authOpt = arepo.findById(id.getAuthorId());
		
		if(authOpt.isPresent()) {
			Author existingAuthor = authOpt.get();
			arepo.delete(existingAuthor);
			
			List<Cart> carts =crepo.findAll();
			for(Cart cart:carts) {
				List<Book> books = cart.getBooks();
				
				while(books.size()>0) {
					Optional<Book> bookOpt = brepo.findById(books.get(0).getBookid());
					Book existingBook = bookOpt.get();
					if(existingBook.getAuthor().getAuthorId()==id.getAuthorId()) {
						books.remove(0);
						brepo.delete(existingBook);
					}
				}
			}
			
			return existingAuthor;
		}
		throw new AuthorException("Invalid author ");
	}
	}
  

}
