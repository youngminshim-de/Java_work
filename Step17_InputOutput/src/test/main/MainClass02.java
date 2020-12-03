package test.main;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;

public class MainClass02 {
	
	public static void main(String[] args) {
		// InputStream은 한글읽기 X(1byte 처리)
		// InputStreamReader는 한글읽기 가능(2byte 처리하기때문)
		// 둘다 한글자 처리용 return type int
		InputStream kbd=System.in;
		InputStreamReader reader=new InputStreamReader(kbd);
		
		try {
			System.out.print("1글자 입력:");
			int code=reader.read();
			System.out.println("code: "+code);
			char ch=(char)code;
			System.out.println(ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("main 메소드가 종료됩니다.");
	}
}
