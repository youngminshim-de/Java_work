package test.main;

import test.auto.Car;
import test.auto.Engine;
import test.mypac.SuperCar;

public class MainClass09 {

	public static void main(String[] args) {
		Car car1=new Car(new Engine());
		Engine engine=null;
		Car car2=new Car(engine);
		car1.drive();
		car2.drive();
		
	}

}
