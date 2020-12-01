package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 *  [ quiz ]
		 *   1. 문자열을 저장할 수 있는 ArrayList 객체생성
		 *   2. Scanner 객체를 이용해서 친구 이름을 반복문 돌면서 5개 입력받아라.
		 *   3. ArrayList 객체에 저장된 내용을 반복문 돌면서 순서대로 출력하세요
		 *      output 형식
		 *      0 번째 친구 이름 : 김구라
		 */
		
		List<String> list=new ArrayList<>();
		Scanner keyboard=new Scanner(System.in);

		for(int i=0; i<5; i++) {
			System.out.print("친구의 이름을 입력하세요 :");
			list.add(keyboard.nextLine());
		}
		for(int i=1; i<=list.size(); i++) {
			System.out.println(i+"번째 친구 이름 : "+list.get(i-1));
		}
		for(String str:list) {
			System.out.println(str);
		}
		                                
	}
}
