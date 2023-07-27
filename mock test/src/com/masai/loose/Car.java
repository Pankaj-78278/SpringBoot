package com.masai.loose;

public class Car implements Vehicle{// dependency

	void start1() {
		System.out.println("car start");
	}

	@Override
	public void go() {
		// TODO Auto-generated method stub
		
		start1();
	}
}
