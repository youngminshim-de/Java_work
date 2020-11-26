package test.mypac;
/*
 *  [ interface]
 *  
 *  - 생성자가 없다 (단독 객체 생성 불가)
 *  - 구현된 메소드는 가질 수 없다 ( abstract method만 가능)
 *  - 필드는 static final 상수만 가질 수 있다.
 *  - data type 의 역할을 할 수 있다.
 *    ex) Remocon r1= x;
 *  - interface type 의 참조값이 필요하다면 구현(implements)
 *    class를 이용해서 객체를 생성해야 한다.
 *  - 클래스는 단일 상속(extends) 이지만 인터페이스는 다중 구현(implements)이 가능하다.
 *    ex) implements A,B
 */
public interface Remocon {
	// field (final이 붙으면 값 수정불가)
	// final로 선언된 field 나 변수의 이름은 관례상 모두 대문자로 표기한다.
	// static final은 생략가능 (생략해도 자동으로 static final이 된다.
	public static final String COMPANY="LG";
	
	// method (abstract method만 가능하다. 구현x)
	public abstract void up();
	// abstract 생략가능하다.
	public void down();
}
