package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass07 {

	public static void main(String[] args) {
		usePhone(new Phone());
		// Phone Type을 제외하고 아래 두 type은 if문에 들어간다.
		// SmartPhone은 HandPhone의 자식클래스이므로
		usePhone(new HandPhone());
		usePhone(new SmartPhone());
		
	}
	public static void usePhone(Phone p) {
		
		// 만일 p가 HandPhone type이 맞다면
		if(p instanceof HandPhone) {
			HandPhone p2=(HandPhone)p;
			p2.call();
			p.call();
		}
		else if(p instanceof SmartPhone) {
			//SmartPhone p3=(SmartPhone)p;
			//p3.call();
			p.call();
		}
		else {
			p.call();
		}
	}

}
