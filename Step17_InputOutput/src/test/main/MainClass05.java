package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass05 {
	public static void main(String[] args) throws IOException {
		PrintStream ps=System.out;
		OutputStream os=ps;
		
		OutputStreamWriter osw=new OutputStreamWriter(os);
		osw.write("ABCDEFG");
		osw.write("\r\n"); // \n, \r 둘다 줄바꿈 기호 -> 두개 다 쓰면 어디서나 개행된다.
		osw.write("1234567");
		osw.flush();
	}
}
