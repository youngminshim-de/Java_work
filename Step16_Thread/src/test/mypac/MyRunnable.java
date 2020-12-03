package test.mypac;
/*
 *  새로운 작업단위(Thread) 를 만드는 방법 2 (더 많이 쓰이는 방법)
 *  
 *  1. Runnable Interface를 구현한 class를 정의한다.
 *  
 *  2. Runnable Interface의 추상 Method run()을 Override한다.
 *  
 *  3. 해당클래스로 생성한 객체의 참조값을 Thread 객체를 생성하며 생성자의 매개변수로 전달한다.
 *  
 *  4. 생성된 Thread 객체의 start() 메소드를 호출하면 새로운 Thread 시작
 *  
 *  5. Interface이면서 메소드가 하나 -> 람다식으로 표현가능 ()->{}
 */

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("무언가 5초(오랜시간)가 걸리는 작업을 합니다.");
			Thread.sleep(5000);
			System.out.println("MyRunnable" +Thread.currentThread().getName()+" 작업 끝");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
