package test;

import java.util.ArrayList;

public class hello_world {
	public static void main(String[] args) {
		System.out.println("hello world");
		a a = new a(18, 18);
		System.out.println(a.age);
	
		
	}
}

class a {
	int age;
	int num;

	public a(int age, int num) {
		super();
		this.age = age;
		this.num = num;
	}
}