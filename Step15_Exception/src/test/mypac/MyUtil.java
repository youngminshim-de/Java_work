package test.mypac;

public class MyUtil {
	public static void draw() {
		System.out.println("5초 동안 그림을 그려요!");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("그림이 완성되었습니다.");
	}
	public static void send() throws InterruptedException {
		System.out.println("5초 동안 전송을 해요");
		Thread.sleep(5000);
		System.out.println("전송을 완료했습니다.");
	}
	
}
