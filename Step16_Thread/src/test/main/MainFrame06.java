package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.DownloadTask;
import test.mypac.SubThread;

public class MainFrame06 extends JFrame implements ActionListener{
	
	public MainFrame06(String title){
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		btn.addActionListener(this);
		
		add(btn,BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		MainFrame06 f=new MainFrame06("Main Frame2");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "알림!!!");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("다운로드를 시작합니다.");
				try {
					for(int i=1; i<=100; i++) {
						System.out.println(i+"% 다운로드중...");
						Thread.sleep(100);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("다운로드를 완료했습니다.");
			}
		}).start();
		
		// 람다식
		new Thread(()->{
			System.out.println("다운로드를 시작합니다.");
			try {
				for(int i=1; i<=100; i++) {
					System.out.println(i+"% 다운로드중...");
					Thread.sleep(100);
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("다운로드를 완료했습니다.");
		}).start();
		
		System.out.println("actionPerformed method가 return 합니다.");
	}
}
