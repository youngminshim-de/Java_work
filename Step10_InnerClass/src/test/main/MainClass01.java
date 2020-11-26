package test.main;
import test.mypac.Zoo;
import test.mypac.Zoo.Cat;
import test.mypac.Zoo.Monkey;

public class MainClass01 {

	public static void main(String[] args) {
		Zoo z1=new Zoo();
		//getMonkey() 는 Monkey Type의 인스턴스를 리턴하는 함수(return new Monkey())
		Monkey m1=z1.getMonkey();
		Cat c1=z1.getCat();
		m1.say();
		c1.say();
		
		// 직접 Zoo class 안의 inner class 의 접근하려면 생성자의 생성이라도
		// Zoo Type의 참조변수로 참조해야한다.
		Monkey m2=z1.new Monkey();
		Cat c2=z1.new Cat();
		

	}

}
