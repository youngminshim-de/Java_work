package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

public class MainClass12 {

	public static void main(String[] args) throws IOException {
		File myFile=new File("c:/myFolder/memo.txt");
		if(!myFile.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
		}
//      첫번째 방법 2byte씩, 즉 한문자씩 가져오기 read는 ascii 코드값 return, null이면 -1 return
		FileReader fr=new FileReader(myFile);
		int code=0;
		while(true) {
			code=fr.read();
			if(code==-1) break;
			System.out.print((char)code);
		}
//      두번째 방법		
//		FileReader fr=new FileReader(myFile);
		
//		char[] cbuf=new char[100];
//		int cnt=fr.read(cbuf,0,cbuf.length); cbuf에 읽어온 문자개수 return
//		
//		for(int i=0;i<cnt;i++) {
//			System.out.print(cbuf[i]);
//		}
//		세번째 방법
//		BufferedReader br=new BufferedReader(new FileReader(myFile));
//		String str=br.readLine(); readLine() 더이상 읽어올 문자열이 업으면 null return
//		System.out.println(str);
//		br.close();
	}

}
