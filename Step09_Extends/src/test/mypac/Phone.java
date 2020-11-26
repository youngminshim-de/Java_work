package test.mypac;

//모든 Class는 Object 클래스를 상속받는다(즉, extends Object가 생략되어있는 것)
public class Phone extends Object {
	public Phone() {
		System.out.println("Phone() 생성자 호출됨");
	}
	public void call() {
		System.out.println("전화를 걸어요");
	}

}
