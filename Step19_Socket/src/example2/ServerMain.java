package example2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		try {
			// 5000번 통신 port를 열고 클라이언트의 접속을 기다린다.
			serverSocket=new ServerSocket(5000);
			/*
			 *  .accept() 메소드는 클라이언트가 접속을 해야지 리턴하는 메소드이다.
			 *  클라이언트가 접속을 해오면 해당 클라이언트와 연결된 Socket 객체의
			 *  참조값을 리턴한다.
			 */
			while(true) {
				System.out.println("클라이언트의 Socket 접속을 기다립니다...");
				Socket socket=serverSocket.accept();
				System.out.println("클라이언트가 접속을 했습니다.");
				String ip=socket.getInetAddress().getHostAddress();
				System.out.println("접속한 클라이언트의 ip 주소: "+ip);
				InputStream is=socket.getInputStream();
				BufferedReader breader=new BufferedReader(new InputStreamReader(is));
				// 개행기호로 1Line을 알기때문에 개행기호도 같이 보내줘야한다.(client에서)
				String str=breader.readLine();
				System.out.println("클라이언트가 전송한 문자열: "+str);
				socket.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("ServerMain main 메소드가 종료됩니다.");
	}
}
