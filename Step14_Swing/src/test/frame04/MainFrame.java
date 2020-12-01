package test.frame04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame 
				implements ActionListener, KeyListener{
	JTextField inputText;
	JLabel label1;
	
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
		// 버튼에 리스너 등록하기
		sendBtn.addActionListener(this);
		
		// 레이블 만들기
		label1=new JLabel();
		// 패널에 추가하기
		topPanel.add(label1);
		inputText.addKeyListener(this);
		
	}
	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	@Override // ActionListener
	public void actionPerformed(ActionEvent e) {
		String msg=inputText.getText();
		// inputText에 적은값을 label에 띄우기
		label1.setText(msg);
	}
	
	// KeyListener
	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		label1.setText("");
		if(code==KeyEvent.VK_ENTER) {
			String msg=inputText.getText();
			label1.setText(msg);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("released");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("typed");
	}
}
