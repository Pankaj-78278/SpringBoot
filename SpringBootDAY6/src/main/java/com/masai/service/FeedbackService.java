package com.masai.service;
import java.util.List;

import com.masai.exception.FeedbackException;
import com.masai.model.Feedback;

public interface FeedbackService {
	public Feedback addFeedback(Feedback feedback )throws FeedbackException;

	public List<Feedback> viewFeedback(Feedback feedback) throws FeedbackException; 
	
	public Feedback ViewfeedbackById(Integer feedBackId) throws FeedbackException;
	
	public Feedback updateFeedBackById(Feedback feedback) throws FeedbackException;
	
	public Feedback deleteFeedback(Integer feedBackId) throws FeedbackException;
}
