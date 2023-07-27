package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.BlogException;
import com.masai.model.Blog;
import com.masai.service.BlogService;

@RestController
public class BlogController {

	@Autowired
	private BlogService bservice;
	
	
	@PostMapping("/masaiblog/blog/register")
    public ResponseEntity<Blog> addAdmin(@RequestBody Blog blog) throws  BlogException {

        Blog savedUser = bservice.addBlog(blog);
        

        return new ResponseEntity<Blog>(savedUser, HttpStatus.CREATED);
    }
}
