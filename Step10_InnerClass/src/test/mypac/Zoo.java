package test.mypac;

public class Zoo {
	// inner class
	public class Monkey{
		public void say() {
			System.out.println("안녕 나는 원숭이!");
		}
	}
	// inner class
	public class Cat{
		public void say() {
			System.out.println("안녕 나는 고양이!");
		}
	}
	// inner class type을 리턴하는 메소드
	public Monkey getMonkey() {
		return new Monkey();
	}
	public Cat getCat() {
		return new Cat();
	}
}
