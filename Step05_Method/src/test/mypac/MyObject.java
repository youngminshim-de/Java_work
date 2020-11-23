package test.mypac;

public class MyObject {
	public void walk() {
		System.out.println("걸음을 걸어요~");
	}
	public int getNumber() {
		int num=10;
		return num;
	}
	public String getGreeting() {
		String greet="안녕하세요";
		return greet;
	}
	public House getHouse() {
		House h=new House();
		return h;
	}
	public void usePhone(Phone p) {
		p.call();
	}
	public static void callPhone(Phone p) {
		p.call();
	}
	public static House buyHouse() {
		return new House();
	}

}
