package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.SubThread;

public class MainFrame03 extends JFrame implements ActionListener{
	
	public MainFrame03(String title){
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		btn.addActionListener(this);
		
		add(btn,BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		MainFrame03 f=new MainFrame03("Main Frame2");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "알림!!!");
//		Thread st=new Thread() {
//			@Override
//			public void run() {
//				try {
//					System.out.println("무언가 5초(오랜시간)가 걸리는 작업을 합니다.");
//					Thread.sleep(5000);
//					System.out.println("SubThread"+Thread.currentThread().getName()+" 작업 끝");
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		};
//		st.start();
		
		// new Thread(){}.start();
		new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("무언가 5초(오랜시간)가 걸리는 작업을 합니다.");
					Thread.sleep(5000);
					System.out.println("SubThread"+Thread.currentThread().getName()+" 작업 끝");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		
		System.out.println("actionPerformed method가 return 합니다.");
	}

}
