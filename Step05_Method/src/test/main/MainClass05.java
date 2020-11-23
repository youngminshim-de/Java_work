package test.main;

import test.mypac.Phone;
import test.mypac.MyObject;
import test.mypac.House;

public class MainClass05 {

	public static void main(String[] args) {
		MyObject.callPhone(new Phone());
		House myHome = MyObject.buyHouse();
	}

}
