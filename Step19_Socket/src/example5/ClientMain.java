package example5;

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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientMain extends JFrame 
		implements ActionListener, KeyListener{
	JTextField text_chat;
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;
	JTextArea ta;
	String chatName; // 대화명을 저장할 필드
	
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
		add(topPanel,BorderLayout.NORTH);
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
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg=text_chat.getText();
		try {
			bw.write(chatName+": "+msg);
			bw.newLine();
			bw.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		text_chat.setText("");
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
					// 도착한 메세지를 JTextArea에 추가
					ta.append(line+"\r\n");
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
			String msg=text_chat.getText();
			try {
				bw.write(chatName+": "+msg);
				bw.newLine();
				bw.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			text_chat.setText("");
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
}
