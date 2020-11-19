package test.mypac;
/*
 *  [클래스의 용도]
 *  1. 객체의 설계도 역할
 *  2. Data Type 의 역할
 *  3. static 자원들을 감싸고 있는 역할
 *  이 class 의 식별자는 test.mypac.Car
 */

public class Car {
	public String name;
	public int cc;
	public Car() {}
	public Car(String name, int cc) {
		this.name=name;
		this.cc=cc;
	}
	public void drive() {
		System.out.println("차가 달리는중입니다.");
	}
	public void printCarStauts() {
		System.out.printf("이름은 %s 번호는 %d입니다.", name,cc);
		System.out.println("");
	}

}
