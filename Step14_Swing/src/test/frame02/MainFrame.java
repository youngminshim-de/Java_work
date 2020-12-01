package test.frame02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {
	public MainFrame(String title) {
		super(title);
		// 레이아웃 매니저 지정하기
		setLayout(new FlowLayout()); // 물 흐르듯이 배치되는 레이아웃
		
		JButton btn1=new JButton("전송");
		btn1.addActionListener((e)->{
			JOptionPane.showMessageDialog(this, "전송");
		});
		JButton btn2=new JButton("수정");
		btn2.addActionListener((e)->{
			JOptionPane.showMessageDialog(this, "수정");
		});
		JButton btn3=new JButton("삭제");
		btn3.addActionListener((e)->{
			JOptionPane.showMessageDialog(this, "삭제");
		});
		add(btn1);
		add(btn2);
		add(btn3);
	}

	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
