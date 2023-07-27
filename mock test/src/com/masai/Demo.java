package com.masai;

//import java.util.ArrayList;

public class Demo {

//	int x=null;
	public void garbageFindOut() {
		System.out.println("this is garbage collection");
	}
	
	public static void main(String[] args) {
	
		Demo d1= new Demo();
		d1=null;

System.out.println(d1);
		
		
	}
}
