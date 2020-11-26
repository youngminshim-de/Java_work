package test.main;

import test.mypac.Hammer;
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
		Weapon w1=new Sword(); // Local Inner Class
		useWeapon(w1);
		
		// Inner Class타입으로 객체 선언불가 (static method 내이므로)
		// 따라서 static method를 그냥 method로 바꾸거나
		// Inner Class를 static으로 선언해야한다.
		// static method 내에서는 static 자원만 쓸 수 있다.
		Weapon w2=new AirPlane(); // Inner Class
		useWeapon(w2);
		
		Weapon w3=new Hammer(); // External Class
		useWeapon(w3);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
