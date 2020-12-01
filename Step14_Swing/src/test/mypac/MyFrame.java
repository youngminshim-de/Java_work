package test.mypac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		setLayout(null);
		JButton btn=new JButton("눌러보셈");
		btn.setBounds(50, 50, 100, 40);
		add(btn);
		btn.addActionListener((e)-> {
			JOptionPane.showMessageDialog(this, "약올리지마");}
		);
		
		JButton sendBtn=new JButton("전송") ;
		sendBtn.setBounds(200, 50, 100, 40);
		add(sendBtn);
		ActionListener listener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 이 때의 this는 listener를 가르킨다. 이에 MyFrame.this로 해줘야함
				JOptionPane.showMessageDialog(MyFrame.this, "전송");
			}
		};
		
	}

}
