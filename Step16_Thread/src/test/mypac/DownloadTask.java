package test.mypac;

public class DownloadTask implements Runnable{

	@Override
	public void run() {
		
		System.out.println("다운로드를 시작합니다.");
		try {
			for(int i=1; i<=100; i++) {
				System.out.println(i+"% 다운로드중...");
				Thread.sleep(100);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("다운로드를 완료했습니다.");
	}

}
