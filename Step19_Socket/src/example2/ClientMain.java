package example2;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		// 1. Socket을 통해서 출력할 문자열을 입력 받아서
		Scanner keyboard=new Scanner(System.in);
		Socket socket=null;
		try {
			// new Socket("접속할 ip 주소", 포트번호)
			// 127.0.0.1 은 Local 나의 Ip주소(this와 같은 개념)
			while(true) {
				System.out.println("전송할 문자열 입력:");
				String input=keyboard.nextLine();
				socket=new Socket("14.63.164.99", 5000);
				System.out.println("서버에 Socket 접속 성공!");
				//2. Socket을 통해서 출력하기
				OutputStream os=socket.getOutputStream();
				OutputStreamWriter writer=new OutputStreamWriter(os);
				writer.write(input);
				writer.write("\r\n");
				writer.flush();
				writer.close();
				socket.close();
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
