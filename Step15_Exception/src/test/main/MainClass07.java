package test.main;

import java.util.Random;

/*
 *  사용자가 예외클래스를 정의하고,
 *  필요한 시점에 예외를 발생시키려면 throw로 날려주면 된다.
 *  
 *  (Exception or RuntimeException 클래스를 상속 받아야 한다.)
 */

public class MainClass07 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		Random ran=new Random();
		int ranNum=ran.nextInt(3);
		if(ranNum==0) {
			throw new HeadacheException("예외발생");
		}
		System.out.println("main 메소드가 종료 되었습니다.");
		
	}
	static class HeadacheException extends RuntimeException{
		public HeadacheException(String msg) {
			super(msg);
		}
	}
	
}

