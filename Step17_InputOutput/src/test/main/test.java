package test.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class test {
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\dudal\\OneDrive\\바탕 화면\\test.txt");
		InputStream input=new FileInputStream(file);
		byte[] b=new byte[1024];
		
		while(input.read()!=-1) {
			input.read(b);
		}
		System.out.println(b);
	}
}
