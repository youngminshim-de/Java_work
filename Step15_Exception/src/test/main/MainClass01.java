package test.main;

import java.util.Scanner;

public class MainClass01 {

	public static void main(String[] args) {
		Scanner keyboard=new Scanner(System.in);
		System.out.print("숫자 입력: ");
		
		String inputNum=keyboard.nextLine();
		try {
			double num=Double.parseDouble(inputNum);
			double result=num+100;
			System.out.println("입력한 숫자+100= " +result);
		}
		catch(NumberFormatException e) {
			// stack에 일어난 일을 콘솔에 출력해준다.
			e.printStackTrace();
			System.out.println("숫자를 입력하세요");
		}
		
		
		System.out.println("Main 메소드가 종료됩니다.");
	}

}
