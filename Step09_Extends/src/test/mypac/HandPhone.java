package test.mypac;

public class HandPhone extends Phone {

	public void call() {
		// super() constructor 호출. super로 참조하여  부모클래스 메소드 접근 가능!
		// this는 참조값을 가리킨다. 즉 자기자신뿐 아니라 상위클래스(부모)의 field&method도 접근 가능!
		// 왜냐하면 상속관계의 있는 class들은 묶여서 하나의 참조값으로 관리되기 때문!
		super.call();
		System.out.println("자식도 전화를 걸어요");
	}
	
	public void takePicture() {
		System.out.println("HandPhone으로 사진을 찍어요");
	}
}
