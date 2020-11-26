package test.main;

import test.mypac.Weapon;

public class MainClass04 {
	public static void main(String[] args) {
		// Weapon class는 abstract class 이므로 new Weapon(); 으로 인스턴스 생성 불가
		// 매번 abstract class를 상속 받는 class 만들지 않아도 된다.
		// 아래와 같은 방법으로 만든다. 즉 불완전한 메소드를 재정의(override) 해주는것.
		// 이름이 없는 익명의 클래스의 생성자의 호출로 봐야한다.(Anonymous Class)
		// new Weapon까지 입력하고 ctrl+space 누르면 자동완성된다.
		// ↓↓ Anonymous Local Inner Class
		Weapon w=new Weapon() {
			@Override
			public void attack() {
				System.out.println("아무거나 공격해요!");
			}
		};
	}
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
