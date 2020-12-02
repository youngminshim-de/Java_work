package test.main;
/*
 * Exception 의 종류는 크게 두가지이다.
 * 
 * 1. RuntimeException 을 상속받아서 만든 실행중에 발생하는 Exception
 * 
 * 2. RuntimeException 을 상속받지 않고 만든 compile(문법체크중) 중에 발생하는 Exception
 *    -> 즉, 실행되기전에 발생
 */
/*
 *  Thread : 코드의 흐름 // sleep() 잠시 흐름을 잡아두는것
 */
public class MainClass05 {
	public static void main(String[] args) {
		System.out.println("Main 메소드가 시작 됩니다.");
		
		// Thread.sleep은 반드시 try & catch 구문으로 묶여야 한다.(아니면 오류남)
		// 바로 Exception을 상속받은 Exception class는 반드시 try&catch구문으로
		// 묶어줘야 한다. (즉, 예외처리가 자동으로 되어있지 않다는 뜻-> 사용자가 해줘야한다)
		try {
			// 스레드(작업단위, Thread) 를 5초 잡아두기
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main 메소드가 종료 됩니다.");
	}
}
