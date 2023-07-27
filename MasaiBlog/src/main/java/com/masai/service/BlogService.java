package com.masai.service;

import com.masai.exception.BlogException;
import com.masai.exception.UserException;
import com.masai.model.Blog;


public interface BlogService {

	public Blog addBlog(Blog blog) throws BlogException;
	
	public Blog addBlogwithUser(Blog blog,Integer userId,String userOtp) throws BlogException,UserException;
}
