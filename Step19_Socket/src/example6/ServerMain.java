package example6;

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

import org.json.JSONArray;
import org.json.JSONObject;

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
		// 클라이언트에게 문자열을 출력할 객체의 참조값을 저장할 필드
		private BufferedWriter bw;
		// Thread가 응대하는 클라이언트의 대화명을 저장할 필드
		private String chatName;
		
		//생성자
		public ServerThread(Socket socket) {
			this.socket=socket;
		}
		// 매개변수로 전달되는 문자열을 Socket 객체를 통해서 출력하는 메소드
		public void broadcast(String msg) throws IOException{
			// 반복문 돌면서 모든 Thread 객체의 참조값을 하나씩 호출
			for(ServerThread tmp:threadlist) {
				// 그냥 bw로 참조할 경우 현재 thread만 참조되지(this.bw이므로)
				tmp.bw.write(msg);
				tmp.bw.newLine();
				tmp.bw.flush();
			}
		}
		// 참여자 목록을 구성해서 모든 클라이언트에게 출력해주는 메소드
		public void setChatNameList() {
			JSONObject jsonObj=new JSONObject();
			JSONArray jsonAry=new JSONArray();
			// Thread 목록에서 대화명을 참조해서 JSONArray에 누적시키기
			for(ServerThread tmp:threadlist) {
				jsonAry.put(tmp.chatName);
			}
			// JSONObject에 필요한 정보를 담는다.
			// {"type":"members", "list":["name1","name2"....]} 형식으로
			jsonObj.put("type", "members");
			jsonObj.put("list", jsonAry);
			
			// broadcast 함수를 출력하여 모든 Thread에 전달한다.
			try {
				broadcast(jsonObj.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
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
					// 누군가(현재 thread가 대응하는 클라이언트) 입장한거라면
					JSONObject jsonObj=new JSONObject(line);
					String type=jsonObj.getString("type");
					
					if(type.equals("enter")) {
						// 필드에 저장한다.
						chatName=jsonObj.getString("name");
						// 모든 client에게 대화명 목록을 보내준다.
						setChatNameList();
					}
					// server와의 접속이 끊기면 while문을 빠져나간다.
					if(line==null) {
						break;
					}
					// server가 특정 client에게 받은 문자열을 모든 client에게 보낸다.
					broadcast(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					// 오류가 나거나 접속 종료된 Thread는 thread list에서 제거 해야한다.
					// threadlist의 Generic=ServerThread // this=ServerThread(현재자신)
					threadlist.remove(this);
					// this가 퇴장한다고 메세지를 보낸다.
					JSONObject jsonObj=new JSONObject();
					jsonObj.put("type", "out");
					jsonObj.put("name", chatName);
					broadcast(jsonObj.toString());
					// 참여자 목록 업데이트
					setChatNameList();
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
