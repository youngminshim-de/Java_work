package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

public class MainClass01 {
	public static void main(String[] args) {
		// abstract class는 객체생성 불가 (attack method가 미완성이므로 abstract method)
		// 애초에 객체를 생성하기 위해 만든 클래스가 아니다.
		// 틀만만들어놓고 상속받아 재정의해서 쓰기 위한 클래스
		// type은 추상클래스로 주로 많이쓰고 객체생성은 자식클래스로
		Weapon w1=new MyWeapon();
		w1.prepare();
		w1.attack();
	}
}
