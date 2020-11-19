package test.main;

import test.mypac.Car;

public class MainClass01 {

	public static void main(String[] args) {
		Car car1=null;
		car1=new Car();//constructor
		Car car2=new Car("BMW-5", 1234);
		Car car3=new Car("Bentz-E", 5678);
		//car2의 참조변수(stack영역) 를 이용해서 인스턴스(heap영역)의 메소드를 호출한다.
		car2.drive();
		car2.printCarStauts();
		car3.printCarStauts();
	}

}
