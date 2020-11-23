package test.main;

import test.mypac.MyObject;
import test.mypac.Phone;

public class MainClass04 {

	public static void main(String[] args) {
		MyObject m1=new MyObject();
		m1.usePhone(new Phone());
		
		Phone p2=new Phone();
		m1.usePhone(p2);
		
		new MyObject().usePhone(new Phone());
	}

}
