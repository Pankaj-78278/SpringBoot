package com.masai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

	    @Id
	    private Integer blogId;

	    @Enumerated(EnumType.STRING)
	    private Category category;

	    private String content;
	    private LocalDateTime timeStamp;
	
	    @JsonIgnore
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "blogUserID")
	    private User user;

	    @JsonIgnore
	    @OneToMany(cascade = CascadeType.ALL)
	    private List<Comment>comments=new ArrayList<>();
}
