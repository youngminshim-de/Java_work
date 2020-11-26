package test.mypac;

public class MyUtil {
	private String owner="김구라";
	
	private void test() {
		System.out.println("MyUtil 테스트 중입니다.");
	}
	/*
	 *  inner class 안에서 자신을 포함하고 있는 클래스(outer class)의
	 *  멤버(field, method)는 접근지정자에 관계없이 자유롭게 접근 할 수 있다.
	 *  이러한 편리함 때문에 Android 프로그래밍 할 때 종종 사용된다.
	 */
	public class User{
		private String owner="Inner김구라";
		public void doSomething() {
			System.out.println(owner); // Inner김구라
			System.out.println(MyUtil.this.owner); // 김구라
			test(); 
			// MyUtil.this.test() 와 같다.
			// 그냥 this 는 User class의 참조값을 가르킨다.
			// 중복되지 않는다면 그냥 사용하면 된다.
			
		}
	}

}
