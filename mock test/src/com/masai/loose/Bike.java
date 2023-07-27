package com.masai.loose;

public class Bike implements Vehicle {// dependecy 
	
	void ride() {
		System.out.println("ride Start");
	}

	@Override
	public void go() {
		// TODO Auto-generated method stub
		ride();
	}
}
