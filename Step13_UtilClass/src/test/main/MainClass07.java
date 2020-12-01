package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Car;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 *  1. ArrayList 객체생성(Car Type을 Generic으로 가지는)
		 *  
		 *  2. Car 객체 3개를 생성해서 ArrayList에 담아보세요.
		 *  
		 *  3. car 객체의 참조값을 하나씩 호출하여 drive() 메소드를 호출
		 */
		List<Car> cars=new ArrayList<>();
		cars.add(new Car("소나타"));
		cars.add(new Car("BMW 520d"));
		cars.add(new Car("Bentz E-Class"));
		
		for(Car c:cars) {
			c.drive();
		}
		
	}

}
