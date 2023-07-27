package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BlogException;
import com.masai.exception.UserException;
import com.masai.model.Blog;
import com.masai.model.CurrentSessionDTO;
import com.masai.model.User;
import com.masai.repository.BlogRepo;
import com.masai.repository.CurrentSessionRepo;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
    private BlogRepo brepo;
	
	@Autowired
	private CurrentSessionRepo crepo;
	
	@Override
	public Blog addBlog(Blog blog) throws BlogException {
	
	        Blog extBlog= brepo.save(blog);
	        return extBlog;
	    
	}

	@Override
	public Blog addBlogwithUser(Blog blog, Integer userId, String userOtp) throws BlogException, UserException {
		 CurrentSessionDTO loginUser= crepo.findByUuid(userOtp);

	        if(loginUser==null) {
	            throw new UserException("User Not Login in System or Provide valid UserOtp");
	        }
	        else{

	            Blog blog1=brepo.findById(blog.getBlogId()).orElseThrow(()-> new BlogException("No Blog Present with given Id"));
	            User user1= new User();
	            user1.getBlog().add(blog1);

	            blog1.setUser(user1);

	            return brepo.save(blog1);

	        }

	    }
	
   
	
}
