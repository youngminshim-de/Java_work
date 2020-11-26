package test.mypac;
/*
 *  클래스 안에 정의할 수 있는 멤버
 *  1. 생성자
 *  2. 필드(변수)
 *  3. 메소드
 *  4. 클래스! <-- 이것이 InnerClass
 */

public class Test {
	
	// 클래스 안에 정의하는 클래스 ↓↓↓ Inner Class라고 한다.
	public class InnerClass{
		
	}
	public class InnerClass2{
		
	}
	/*
	 *  메소드 안에 정의할 수 있는것?
	 *  1. 지역변수 (Local Variable)
	 *  2. 지역 내부 클래스 (Local Inner Class) <- 해당 메소드 안에서만 쓸 수 있겠지 당연
	 */
	public void test1() {
		class LocalInnerClass{
			public void aa() {
				System.out.println("Local Inner Class 내부의 함수호출됨");
			}
		}
		LocalInnerClass a=new LocalInnerClass();
		a.aa();
		
	}
	

}
