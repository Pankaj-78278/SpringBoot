package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentSession {
	
		
	    @Column(unique = true)
	    @jakarta.persistence.Id
	    private Integer Id;
	    private String type;
	    private String uuid;
	    private LocalDateTime localDateTime;
	
}
