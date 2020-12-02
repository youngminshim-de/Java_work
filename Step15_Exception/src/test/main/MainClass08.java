package test.main;

import test.mypac.MyUtil;

public class MainClass08 {
	public static void main(String[] args) {
		MyUtil.draw();
		
		// MyUtil Class에서 throw 날린 method
		// 결국 사용할 곳에서 다시 정의해줘야 한다.
		try {
			MyUtil.send();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
