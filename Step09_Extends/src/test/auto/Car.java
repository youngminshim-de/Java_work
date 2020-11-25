package test.auto;

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
