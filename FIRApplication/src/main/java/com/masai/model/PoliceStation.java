package com.masai.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PoliceStation {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    
	    @NotNull
	    private String stationCode;
	    
	    @NotNull(message = "Address is required")
	    private String address;
	    
	    @NotNull
	    private String officerInCharge;
	    
	    @OneToMany(mappedBy = "policeStation")
	    private List<Police> policeOfficer;
	    
	    @OneToMany(mappedBy = "policeStation")
	    private List<FIR> filedFIR;

}
