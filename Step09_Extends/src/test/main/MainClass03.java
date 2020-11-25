package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass03 {

	public static void main(String[] args) {
		//Upcasting
		Object p1=new HandPhone();
		
		//DownCasting
		Phone p2=(Phone) p1;
		HandPhone p3=(HandPhone) p1;
		p3.call();
		p3.takePicture();
	}

}
