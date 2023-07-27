package com.masai.exception;

import java.time.LocalDateTime;

public class ErrorDetail  {

	private LocalDateTime Timestamp;
	private String message;
	private String details;
	
	
	
	public ErrorDetail(LocalDateTime timestamp, String message, String details) {
		super();
		Timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public ErrorDetail() {
		super();
	}

	@Override
	public String toString() {
		return "ErrorDetail [Timestamp=" + Timestamp + ", message=" + message + ", details=" + details + "]";
	}
	
	public LocalDateTime getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		Timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
