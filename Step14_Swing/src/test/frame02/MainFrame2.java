package test.frame02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame2 extends JFrame{
	ActionListener sendListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MainFrame2.this, "전송합니다");
			
		}
	};
	ActionListener updateListener=(e)->{
		JOptionPane.showMessageDialog(MainFrame2.this, "수정합니다");
	};
	ActionListener deleteListener=(e)->{
		JOptionPane.showMessageDialog(MainFrame2.this, "삭제합니다");
	};
	
	public MainFrame2(String title) {
		super(title);
		setLayout(new FlowLayout());
		
		JButton btn1=new JButton("전송");
		JButton btn2=new JButton("수정");
		JButton btn3=new JButton("삭제");
		btn1.addActionListener(sendListener);
		btn2.addActionListener(updateListener);
		btn3.addActionListener(deleteListener);
		
		add(btn1);
		add(btn2);
		add(btn3);
	}
	public static void main(String[] args) {
		MainFrame2 mf2=new MainFrame2("메인프레임");
		mf2.setBounds(100, 100, 500, 300);
		mf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf2.setVisible(true);
	}

}
