package test.main;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class MainClass03 {
	
	public static void main(String[] args) {
		// InputStream은 한글읽기 X(1byte 처리)
		// InputStreamReader는 한글읽기 가능(2byte 처리하기때문)
		// 둘다 한글자 처리용 return type int
		InputStream kbd=System.in;
		InputStreamReader ireader=new InputStreamReader(kbd);
		BufferedReader breader=new BufferedReader(ireader);
		
		try {
			System.out.print("입력하세요 : ");
			String str=breader.readLine();
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main 메소드가 종료됩니다.");
	}
}
