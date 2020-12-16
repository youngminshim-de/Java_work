package example6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * 	- 대화방에 현재 누가 참여하고 있는지 목록 출력하기
 * 	- 누가 새로 입장했는지 메세지 출력하기
 * 	- 누가 퇴장 했는지 메세지 출력하기
 * 
 * 	서버에 전달되는 메세지의 종류
 * 
 * 	1. 일반 대화 메세지 {"type":"msg", "name":"김구라", "content":"안녕하세요!"}
 * 	2. 누군가 입장했을때 메세지 {"type":"enter", "name":"김구라"}
 * 	3. 누군가 퇴장했을때 메세지 {"type":"out", "name":"원숭이"}
 * 	4. 참여자 목록 메세지 {"type":"members", "list":["주뎅이","덩어리","개다리"]}
 * 	
 */
public class ClientMain extends JFrame 
		implements ActionListener, KeyListener{
	JTextField text_chat;
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	JTextArea ta;
	String chatName; // 대화명을 저장할 필드
	JList<String> jList; // 대화명의 목록을 저장할 List
	
	public ClientMain(String title) {
		super(title);
		JLabel label_text=new JLabel("입력");
		setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.MAGENTA);
		JButton btn_send=new JButton("보내기");
		text_chat=new JTextField(20);
		topPanel.add(label_text);
		topPanel.add(text_chat);
		topPanel.add(btn_send);
		add(topPanel,BorderLayout.SOUTH);
		btn_send.addActionListener(this);
		
		// 채팅메세지를 출력할 TextArea 객체 생성
		ta=new JTextArea();
		// 스크롤 가능한 UI에 포장후
		JScrollPane scPane=new JScrollPane(ta,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scPane,BorderLayout.CENTER);
		// 수정불가하도록 -> 오직 출력용도
		ta.setEditable(false);
		// JTextField에 keyListener 구현하기
		text_chat.addKeyListener(this);
		
		// 참여자 List를 출력할 준비
		jList=new JList<>();
		jList.setBackground(Color.GREEN);
		
		JPanel rightPanel=new JPanel();
		rightPanel.add(jList);
		add(rightPanel, BorderLayout.EAST);
		
		// Socket 서버에 접속하기
		connect();
	}

	public static void main(String[] args) {
		ClientMain q=new ClientMain("채팅");
		q.setBounds(100, 100, 500, 500);
		q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		q.setVisible(true);

	}
	// Socket 서버에 접속을 하는 메소드
	public void connect() {
		// 대화명을 입력 받아서 필드에 저장하기
		chatName=JOptionPane.showInputDialog(this, "대화명을 입력하세요.");
		// inputdialog 아무것도 입력하지 않고 취소 누르면 null로     ok 누르면 빈문자열이 들어간다.
		if(chatName==null||chatName=="") {chatName="바보";}
		try {
			socket=new Socket("14.63.164.99",5000);
			// 서버에 문자열을 출력할 객체
			bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 서버가 전송하는 문자열을 읽어들일 객체
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// Main Thread는 클라이언트의 입력에 대응해야 되기 때문에
			// 새로운 Thread를 시작시켜서 서버에서 문자열이 도착할때 까지 지속적으로 대기한다.(언제도착할지 모르므로)
			new ClientThread().start();
			// 내가 입장한다고 서버에 메세지를 보낸다.
			JSONObject jsonObj=new JSONObject();
			// JSONObject에 정보를 담는다.
			jsonObj.put("type", "enter");
			jsonObj.put("name", chatName);
			String msg=jsonObj.toString();
			bw.write(msg);
			bw.newLine();
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		sendMessage();
	}
	// 새로운 Thread를 만들어 Main Thread(Server에게 문자열 전송)와는 별개로
	// 서버에서 문자열이 전송될 떄 까지 지속적으로 대기하는 객체를 만들기 위한 class(즉, 양방향 통신위함)
	class ClientThread extends Thread{
		@Override
		public void run() {
			while(true) {
				try {
					// 대기하다가 문자열이 도착하면 메소드가 리턴한다.
					String line=br.readLine();
					JSONObject jsonObj=new JSONObject(line);
					String type=jsonObj.getString("type");
					//String name=jsonObj.getString("name");
					if(type.equals("enter")) {
						String name=jsonObj.getString("name");
						ta.append("[ "+name+" ]"+" 님이 입장하셨습니다.");
						ta.append("\r\n");
					}else if(type.equals("msg")) {
						String name=jsonObj.getString("name");
						String content=jsonObj.getString("content");
						ta.append(name+": "+content);
						ta.append("\r\n");
					}else if(type.equals("members")) {
						// "list"라는 키값으로 저장된 JSONArray 객체 얻어오기
						JSONArray jsonArr=jsonObj.getJSONArray("list");
						Vector<String> list=new Vector<>();
						for(int i=0; i<jsonArr.length();i++) {
							list.add(jsonArr.getString(i));
						}
						// Vector(대화명의 list)를 JList에 연결하기
						jList.setListData(list);
					}else if(type.equals("out")) {
						String name=jsonObj.getString("name");
						ta.append("#[ "+name+" ]#"+ " 님이 퇴장하셨습니다.");
						ta.append("\r\n");
					}
					// server와의 접속이 끊기면 while문을 빠져나간다.
					if(line==null) {
						break;
					}
					// 출력할 문서의 높이
					int height=ta.getDocument().getLength();
					ta.setCaretPosition(height);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			sendMessage();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	// 메세지를 전송하는 메소드
	public void sendMessage() {
		String msg=text_chat.getText();
		try {
			JSONObject jsonObj=new JSONObject();
			jsonObj.put("type", "msg");
			jsonObj.put("name", chatName);
			jsonObj.put("content", msg);
			String json=jsonObj.toString();
			bw.write(json);
			bw.newLine();
			bw.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		text_chat.setText("");
	}
}
