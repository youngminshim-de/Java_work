package example1;

import java.net.Socket;

public class ClientMain {

	public static void main(String[] args) {
		Socket socket=null;
		try {
			// new Socket("접속할 ip 주소", 포트번호)
			// 127.0.0.1 은 Local 나의 Ip주소(this와 같은 개념)
			socket=new Socket("127.0.0.1", 5000);
			System.out.println("서버에 Socket 접속 성공!");
			socket.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
