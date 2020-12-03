package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.DownloadTask;
import test.mypac.SubThread;

public class MainFrame04 extends JFrame implements ActionListener{
	
	public MainFrame04(String title){
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		btn.addActionListener(this);
		
		add(btn,BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		MainFrame04 f=new MainFrame04("Main Frame2");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "알림!!!");
		
		Runnable dt=new DownloadTask();
		Thread st=new Thread(dt);
		st.start();
		
		System.out.println("actionPerformed method가 return 합니다.");
	}

}
