package test.main;
import test.mypac.Car;

public class MainClass04 {

	public static void main(String[] args) {
		//Car type을 담을 수 있는 방3개 짜리 배열객체를 생성
		//cars 배열에 저장된 car 객체의 참조값을 참조해서 drive() 메소드를 호출해보세요
		
		Car[] cars=new Car[3];
		for(int i=0; i<cars.length; i++) {
			cars[i] = new Car();
			cars[i].drive();
		}

	}

}
