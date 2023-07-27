package com.masai.loose;

import com.masai.A;

public class Demo extends A {

	public static void main(String[] args) {
		Travel t= new Travel();
		t.setV(new Bike());
		t.journey();
		A a2 =new A();
		
	}
}
