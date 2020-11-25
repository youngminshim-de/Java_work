package test.main;

import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * 	Phone p1=new Phone();
		 * 	SmartPhone p2=(SmartPhone)p1;
		 *  캐스팅이 될 수 없다.
		 *  Phone 객체를 만들었으므로 자식 객체 SmartPhone 객체는 존재하지 않는다.
		 *  따라서 p2가 참조할 수 없을 뿐더러, 캐스팅도 되지 않는다. SmartPhone 객체가 존재하지 않기때문
		 *  (SmartPhone 객체가 생성이 되지 않았다.)
		 */
		
		Phone p1=new SmartPhone();
		
		SmartPhone p2=(SmartPhone)p1;
		p2.doInternet();
	}


}
