package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass06 {
	//실행순서가 시작되는 특별한 main 메소드
	public static void main(String[] args) {
		// 선언된 매개변수형=Phone p
		// Phone p=new SmartPhone() upcasting이 가능하므로 아래와 같이 사용가능
		usePhone(new Phone());
		usePhone(new HandPhone());
		usePhone(new SmartPhone());
	}
	//Phone type을 매개변수로 하는 static 메소드
	public static void usePhone(Phone p) {
		p.call();
		
	}

}
