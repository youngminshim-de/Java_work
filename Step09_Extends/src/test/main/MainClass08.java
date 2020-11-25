package test.main;

import test.mypac.Phone;
import test.mypac.HandPhone;
import test.mypac.SmartPhone;

public class MainClass08 {

	public static void main(String[] args) {
		System.out.println("시작");
		Phone p1=null;
		HandPhone p2=null;
		SmartPhone p3=null;
		Phone p4=new Phone();
		usePhone(p1);
		usePhone(p2);
		usePhone(p3);
		System.out.println("종료");
	}
	public static void usePhone(Phone p) {
		if(p==null) {
			// p==null 이기때문에, 생성된 객체가 없기 때문에 instanceof 조건문에 안걸린다.
			if(p instanceof HandPhone) {
				p=new HandPhone();
				HandPhone p2=(HandPhone)p;
				p2.call();
			}
			else if(p instanceof SmartPhone) {
				p=new SmartPhone();
				SmartPhone p2=(SmartPhone)p;
				p2.call();
			}
			else {
				p=new Phone();
				p.call();
			}
		}
		
		
	}

}
