package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass06 {
	public static void main(String[] args) throws IOException {
		PrintStream ps=System.out;
		OutputStream os=ps;
		OutputStreamWriter osw=new OutputStreamWriter(os);
			
		BufferedWriter bw=new BufferedWriter(osw);
		bw.write("안녕하세요");
		bw.newLine(); // 개행해주는 메소드
		bw.write("ABCDEFG");
		bw.newLine();
		bw.write("1234567");
		bw.flush();
	}
}
