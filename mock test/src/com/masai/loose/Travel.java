package com.masai.loose;

public class Travel { //dependent class 
	
	// i m not assigning the object to the main control their is need to
//	the external entity 
	private Vehicle v;
	
//	public Travel(Vehicle v) {
//	this.v = v;
//	}
	
	public void setV(Vehicle v) {
		this.v = v;
	}
	
//	Car c= new Car();
	

	public void journey() {
		
		v.go();
		System.out.println("journey will start");
	}

	
	
	
}
