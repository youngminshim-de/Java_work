package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass02 {

	public static void main(String[] args) {
		/* 
		 *  [ 다형성(Polymorphism) ]
		 *  
		 *   - 객체는 여러가지 type을 가질 수 있다.
		 *   - 상속 관계에 따라서 여러가지 type이 된다.
		 *   - 아래의 HandPhone 객체는 3가지 type을 가진다.
		 */
		
		// 상속관계 Object > Phone > HandPhone
		// HandPhone 객체를 생성해서 Phone, Object 부모 클래스 type의 참조변수에 담을 수 있다.(Up-Casting)
		// But 반대의 경우는 안된다.
		HandPhone p1=new HandPhone();
		Phone p2=new HandPhone();
		Object p3=new HandPhone();
	}

}
