package test.main;

import test.mypac.MyObject;

public class MainClass01 {

	public static void main(String[] args) {
		MyObject m1=new MyObject();
		m1.walk();
		m1.getNumber();
		m1.getGreeting();
		int a=m1.getNumber();
		String b=m1.getGreeting();

	}

}
