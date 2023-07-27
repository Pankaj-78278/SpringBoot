package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Police {
    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull(message = "OfficerName is required")
	    private String officerName;
	    

		@Size(min=10,max=10,message= "mobile no should be 10 digit" )
	    private String mobileNum;
	    
		@NotNull
		private String department;
		
		@NotNull
		private List<FIR> firFiled=new ArrayList<>();
		
		@NotNull
		private List<FIR> casesClosed= new ArrayList<>();
	    
	    @ManyToOne
	    private PoliceStation policeStation;


}
