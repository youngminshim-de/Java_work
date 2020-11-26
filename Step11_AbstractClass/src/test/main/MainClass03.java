package test.main;

import test.mypac.Weapon;

public class MainClass03 {
	// Inner Class
	static class AirPlane extends Weapon{
		@Override
		public void attack() {
			System.out.println("공중 공격");
			
		}
	}
	public static void main(String[] args) {
		// Local Inner Class
		class Sword extends Weapon{
			@Override
			public void attack() {
				System.out.println("검으로 공격");
			}
		}
		Weapon w1=new Sword();
		useWeapon(w1);
		// Inner Class 선언불가 static method 내이므로
		// 따라서 method를 static 없애거나
		// Inner Class를 static으로 선언해야한다.
		// static method 내에서는 static 자원만 쓸 수 있다.
		Weapon w2=new AirPlane();
		useWeapon(w2);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
