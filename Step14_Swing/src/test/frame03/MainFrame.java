package test.frame03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener{
	JTextField inputText;
	
	public MainFrame(String title) {
		super(title);
		// Layout Manager 설정
		setLayout(new BorderLayout());

		// 텍스트필드 & 버튼 생성
		inputText=new JTextField(10);
		JButton sendBtn=new JButton("전송");
		
		// 패널 객체 생성
		JPanel topPanel=new JPanel();
		// 패널에 텍스트필드 & 버튼 추가
		topPanel.add(inputText);
		topPanel.add(sendBtn);
		topPanel.setBackground(Color.BLUE);
		
		// 패널 째로 프레임의 North에 배치하기
		add(topPanel, BorderLayout.NORTH);
		sendBtn.addActionListener(this);
	}
	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg=inputText.getText();
		// inputText에 적은값을 alert창에 띄우기
		JOptionPane.showMessageDialog(this, msg);
	}
}
