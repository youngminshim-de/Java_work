package test.mypac;

// 1. 추상클래스를 상속받으면
public class MyWeapon extends Weapon{

	// 2. 미완성의 추상메소드를 반드시 오버라이딩 해야한다.
	@Override
	public void attack() {
		System.out.println("attack!");
	}


	
	
}
