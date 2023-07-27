package com.masai.model;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
public class FIR {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer firId;
    
    private String crimeDetail;
    
    @OneToOne(cascade = CascadeType.ALL)
    private User applicant;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<User> criminals;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Police officer;
    
    private LocalDateTime timeStamp;
    
    @OneToOne(cascade = CascadeType.ALL)
    private PoliceStation policeStation;
    
    private Boolean isOpen;
	

	
}
