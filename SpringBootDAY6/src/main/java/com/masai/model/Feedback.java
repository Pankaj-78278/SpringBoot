package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Feedback {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer feedBackId;
//	
//	@NotNull(message="name should not be null")
//	@Size(min =1,max =10,message="Feedback should be length between min 1 and max 10 ")
	private Integer driverRating ;
	
//	@NotNull(message="name should not be null")
//	@Size(min =1,max =10,message="Feedback should be length between min 1 and max 10 ")
	private Integer serviceRating ;
//	
//	@NotNull(message="name should not be null")
//	@Size(min =1,max =10,message="Empname should be length between min 1 and max 10 ")
	private Integer overAllRating;
	
	@NotNull(message="comment should not be null")
	private String comment;

	

	public Feedback(Integer feedBackId, Integer driverRating, Integer serviceRating, Integer overAllRating,
			@NotNull(message = "comment should not be null") String comment) {
		super();
		this.feedBackId = feedBackId;
		this.driverRating = driverRating;
		this.serviceRating = serviceRating;
		this.overAllRating = overAllRating;
		this.comment = comment;
	}

	public Feedback() {
		super();
	}

	@Override
	public String toString() {
		return "Feedback [feedBackId=" + feedBackId + ", driverRating=" + driverRating + ", serviceRating="
				+ serviceRating + ", overAllRating=" + overAllRating + ", comment=" + comment + "]";
	}

	public Integer getFeedBackId() {
		return feedBackId;
	}

	public void setFeedBackId(Integer feedBackId) {
		this.feedBackId = feedBackId;
	}

	public Integer getDriverRating() {
		return driverRating;
	}

	public void setDriverRating(Integer driverRating) {
		this.driverRating = driverRating;
	}

	public Integer getServiceRating() {
		return serviceRating;
	}

	public void setServiceRating(Integer serviceRating) {
		this.serviceRating = serviceRating;
	}

	public Integer getOverAllRating() {
		return overAllRating;
	}

	public void setOverAllRating(Integer overAllRating) {
		this.overAllRating = overAllRating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
		 
}
