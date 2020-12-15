package example4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientMain extends JFrame implements ActionListener{
	JTextField text_chat;
	
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
	}

	public static void main(String[] args) {
		
		ClientMain q=new ClientMain("채팅");
		q.setBounds(100, 100, 500, 300);
		q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		q.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg=text_chat.getText();
		Socket socket=null;
		try {
			// new Socket("접속할 ip 주소", 포트번호)
			// 127.0.0.1 은 Local 나의 Ip주소(this와 같은 개념)
				socket=new Socket("127.0.0.1", 5000);
				System.out.println("서버에 Socket 접속 성공!");
				//2. Socket을 통해서 출력하기
				OutputStream os=socket.getOutputStream();
				OutputStreamWriter writer=new OutputStreamWriter(os);
				writer.write(msg);
				writer.write("\r\n");
				writer.flush();
				//writer.close();
				// 3. Socket을 통해서 입력받기
				InputStream is=socket.getInputStream();
				BufferedReader br=new BufferedReader(new InputStreamReader(is));
				// 서버가 전송한 문자열 읽어들이기
				String str=br.readLine();
				System.out.println(str);
				//br.close();
				socket.close();
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(this, "전송되었습니다.");
		text_chat.setText("");
	}

}
