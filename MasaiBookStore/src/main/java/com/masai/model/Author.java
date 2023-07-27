package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Author {

	
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authorId;
	private String mobileNum ;
	private String address;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "author")
	private List<Book> allBooks=new ArrayList<>();
}
