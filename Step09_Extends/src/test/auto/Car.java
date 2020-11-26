package test.auto;

// 클래스의 접근지정자는 default or public 둘중하나이다.
// default 의 경우 class Car 라고 선언
// 이러면 같은 패키지내에서만 import 가능.-> 즉, 다른 패키지에서 import 불가
// 그러나 public class 명은 클래스를 만들때 이름과 같아야 한다.
// 즉 하나의 class 파일 안에서 public class는 하나 밖에 존재할 수 없다.
public class Car {
	
	protected Engine engine;
		
	public Car(Engine engine) {
		this.engine=engine;
	}
	public void drive() {
		if(engine==null) {
			System.out.println("Engine이 없어서 달릴수가 없어요ㅠㅠ");
			return;
		}
		System.out.println("붕붕~");
	}
}