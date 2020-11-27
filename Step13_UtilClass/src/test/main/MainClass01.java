package test.main;

import java.util.Scanner;


/*
 *  키보드로부터 문자열을 입력받기 위한 Scanner 객체를 생성한다.
 *  생성자의 매개변수로는 키보드로부터 입력을 받을 수 있는 InputStream type
 *  객체를 전달해주어야 한다.
 *  해당 객체는 System 클래스에 static final 상수 in 이라는 field에
 *  참조값이 미리 준비되어 있으므로 그값을 생성자에 전달하면 된다.
 */
public class MainClass01 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("입력하세요 : ");
		
		String str =keyboard.nextLine();
		System.out.println("입력한 문자열 : "+str);
		
	}
}
