package test.main;

import test.mypac.*;

public class MainClass01 {

	public static void main(String[] args) {
		FruitBox<Apple> fb1=new FruitBox<>();
		FruitBox<Banana> fb2=new FruitBox<>();
		FruitBox<Orange> fb3=new FruitBox<>();
		
		fb1.setItem(new Apple());
		fb2.setItem(new Banana());
		fb3.setItem(new Orange());
		
		Apple a=fb1.getItem();
		Banana b=fb2.getItem();
		Orange o=fb3.getItem();

	}

}
