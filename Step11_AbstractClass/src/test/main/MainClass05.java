package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	public static void main(String[] args) {
		// 한번만 호출하고 싶으면 메소드의 매개변수에 바로 넣어서 사용
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("아무거나 공격해요");		
			}
		});
	}
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
