package test.mypac;

/*
 *  새로운 작업단위(스레드) 만드는 방법 1
 *  
 *  1. Thread 클래스를 상속받는다.
 *  2. run() Method를 override 한다.
 *  3. 객체를 생성한다.
 *  4. 해당 객체의 start() 메소드를 호출할면 run() 메소드가 호출되며
 *     새로운 작업단위(Thread)가 시작된다.
 */

public class SubThread extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("무언가 5초(오랜시간)가 걸리는 작업을 합니다.");
			Thread.sleep(5000);
			System.out.println("SubThread"+Thread.currentThread().getName()+" 작업 끝");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
