package example5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServerMain {
	// 접속한 클라이언트를 응대하는 Thread 객체의 목룍을 담을 필드
	static List<ServerThread> threadlist;

	public static void main(String[] args) {
		//ArrayList 객체를 생성해서 필드에 저장하기
		threadlist=new ArrayList<>();
		ServerSocket serverSocket=null;
		try {
			serverSocket=new ServerSocket(5000);
			while(true) {
				System.out.println("클라이언트의 Socket 접속을 기다립니다...");
				// 1. 클라이언트가 접속을 해오면
				Socket socket=serverSocket.accept();
				// 2. 새로운 Thread를 시작시킨다.
				ServerThread st=new ServerThread(socket);
				st.start();
				// 3. 시작된 Thread의 참조값을 thread list에 누적시킨다.
				threadlist.add(st);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("ServerMain main 메소드가 종료됩니다.");
	}
	// Thread Inner Class 설계
	static class ServerThread extends Thread{
		// 필드 (클라이언트와 연결된 Socket 객체의 참조값을 저장할 필드)
		private Socket socket;
		private BufferedWriter bw;
		public ServerThread(Socket socket) {
			this.socket=socket;
		}
		// 매개변수로 전달되는 문자열을 Socket 객체를 통해서 출력하는 메소드
		public void broadcast(String msg) throws IOException{
			// 해당 메소드를 호출하는 곳에서 try/catch로 잡아두었기 때문에
			// 해당 함수들은 throws로 받아도 된다.
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
		@Override
		public void run() {
			try {
				// 클라이언트가 전송하는 문자열을 읽어들일 객체
				BufferedReader br=
						new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// 클라이언트에게 문자열을 출력할 객체
				bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				while(true) {
					// 문자열이 한줄이 전송될 때 까지 blocking 되는 메소드
					// 오류나거나 접속이 종료 되면 Exception으로 날라간다. 해당 line에서
					String line=br.readLine();
					for(ServerThread tmp:threadlist) {
						tmp.broadcast(line);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 오류가 나거나 접속 종료된 Thread는 thread list에서 제거 해야한다.
			// threadlist의 Generic=ServerThread // this=ServerThread(현재자신)
			threadlist.remove(this);
		}
	}
}
