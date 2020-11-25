package test.main;

import test.auto.Car;
import test.auto.Engine;
import test.mypac.SuperCar;

public class MainClass10 {

	public static void main(String[] args) {
		SuperCar scar1=new SuperCar(new Engine());
		scar1.drive();
		scar1.driveFast();
		
		Car scar2=new SuperCar(null);
		SuperCar scar3=(SuperCar)scar2;
		scar3.driveFast();
	}

}
