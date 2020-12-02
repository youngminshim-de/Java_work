package test.main;

import java.util.Scanner;

public class MainClass02 {

	public static void main(String[] args) {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("나눌 수 입력:");
		String inputNum1=keyboard.nextLine();
		System.out.println("나누어지는 수 입력:");
		String inputNum2=keyboard.nextLine();
		try {
			int num1=Integer.parseInt(inputNum1);
			int num2=Integer.parseInt(inputNum2);
			int result=num2/num1;
			int result2=num2%num1;
			
			System.out.println(num2+" 를 "+num1+" 으로 나눈 몫은 "+result);
			System.out.println(num2+" 를 "+num1+" 으로 나눈 나머지는 "+result2);
		}
		catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			System.out.println("숫자를 입력하세요");
		}
		catch(ArithmeticException ae) {
			ae.printStackTrace();
			System.out.println("나눌 수는 0을 입력할 수 없습니다.");
		}
			System.out.println("Main 종료");
		
		
	}

}
