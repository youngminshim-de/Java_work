package test.main;

public class MainClass06 {
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Main 메소드가 종료 됩니다.");
	}

}
