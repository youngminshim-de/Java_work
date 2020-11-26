package test.main;

import test.mypac.Hammer;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 *  Weapon Class를 상속받는 클래스를 정의
		 *  useWeapon 메소드 호출해보시오
		 */

		Weapon w1=new Hammer();
		useWeapon(w1);
	}

	// Weapon type의 참조값을 인자로 전달 받는 메소드
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
