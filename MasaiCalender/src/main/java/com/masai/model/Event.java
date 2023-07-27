package com.masai.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @NotNull
	    private String title;

	    @NotNull
	    private LocalDate startDate;

	    @NotNull
	    private LocalDate endDate;

	    @NotNull
	    private LocalTime startTime;

	    @NotNull
	    private LocalTime endTime;

	    @NotNull
	    private Boolean isRecurring;

	    
	
}
