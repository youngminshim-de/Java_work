package test.main;

import java.io.File;

public class MainClass09 {

	public static void main(String[] args) {
		File myFile=new File("c:/myFolder");
		if(!myFile.exists()) {
			myFile.mkdir(); // directory 생성
//			myFile.mkdirs(); 상위 directory 가 없으면 상위 directory까지 생성
			System.out.println("c:/myFolder 를 생성했습니다.");
		}
		else {
			System.out.println("이미 존재합니다");
		}
		

	}

}
