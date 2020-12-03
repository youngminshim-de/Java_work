package test.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

/*
 *  1. c:/myFolder/memo.txt 파일을 만든다.
 *  2. "김구라" "해골" "원숭이" "주뎅이" "덩어리" 문자열을 파일에 출력하기
 *  
 */
public class MainClass11 {

	public static void main(String[] args) throws IOException {
	
		File myFile=new File("c:/myFolder/memo.txt");
		if(!myFile.exists()) {
			myFile.createNewFile();
			System.out.println("파일을 생성했습니다.");
		}
		FileWriter fw=new FileWriter(myFile);
		fw.write("\"김구라\" \"해골\" \"원숭이\" \"주뎅이\" \"덩어리\"");
		fw.flush();
		fw.close();
		
	}

}
