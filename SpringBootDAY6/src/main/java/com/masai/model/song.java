package com.masai.model;

public class song {
//	String name;
//    int duration;
//    int popularity;
	static void change(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=arr[i]-1;
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		change(arr);
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}
	
//	public song(String name, int duration, int popularity) {
//		super();
//		this.name = name;
//		this.duration = duration;
//		this.popularity = popularity;
//	}
//    
    
}
