package test.mypac;

import test.auto.Car;
import test.auto.Engine;

public class SuperCar extends Car {

	public SuperCar(Engine engine) {
		// 부모의 constructor 초기화, 부모의 default 생성자가 없으니,
		// 부모의 constructor도 초기화 될 수 있도록 값을 전달해야 한다.
		super(engine);
	}
	public void driveFast() {
		if(super.engine==null) {
			System.out.println("Engine이 없어서 존나 빨리 못달려요ㅠㅠ");
			return;
		}
		System.out.println("존나 빨리 달려요");
	}
	

}
