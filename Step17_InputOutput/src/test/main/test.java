package test.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class test {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fin=new FileInputStream("c:/myFolder/1.jpg");
		FileOutputStream fout=new FileOutputStream("c:/myFolder/copy.jpg");
		// Buffered 스트림을 이용하면 Buffer에 넣어놓은것과 같은속도
		// 즉, 지가 알아서 버퍼에 저장한다.
		BufferedInputStream bin=new BufferedInputStream(fin);
		BufferedOutputStream bout=new BufferedOutputStream(fout);
		int data=0;
		long start=System.currentTimeMillis();
		while(true) {
			data=bin.read();
			if(data==-1) {break;}
			bout.write(data);
		}
		long end=System.currentTimeMillis();
		System.out.println("복사하는데 걸린 시간은: "+ (end-start)+"mill");
		bin.close();
		bout.close();
	}
}
