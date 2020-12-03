package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) throws IOException {
		PrintStream ps=System.out;
		OutputStream os=ps;
		os.write(65);
		os.write(66);
		os.write(67);
		os.flush();// 출력
	}
}
