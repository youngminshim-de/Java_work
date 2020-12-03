package test.main;

import java.io.IOException;
import java.io.InputStream;

public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작됩니다.");
		InputStream input=System.in;
		try {
			int code=input.read();
			System.out.println("code: "+code);
			char ch=(char)code;
			System.out.println(ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("main 메소드가 종료됩니다.");
	}
}
