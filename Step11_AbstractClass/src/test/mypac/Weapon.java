package test.mypac;

	// abstract method가 있다면 class는 abstract class로 선언되어야 한다.
public abstract class Weapon {
	// 무기 작동을 준비하는 메소드
	public void prepare() {
		System.out.println("무기 작동을 준비 합니다.");
	}
	//공격하는 메소드
	// 원래 비어있어도 {} 처리해줘야 문법오류 안난다.
	// But abstract 로 선언하면 {} 안써도 된다.
	// public void attack() {};
	public abstract void attack();
}
