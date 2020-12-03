package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame01 extends JFrame implements ActionListener{
	
	public MainFrame01(String title){
		super(title);
		setLayout(new BorderLayout());
		JButton btn=new JButton("알림 띄우기");
		btn.addActionListener(this);
		
		add(btn,BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		MainFrame01 f=new MainFrame01("Main Frame1");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "알림!!!");
		try {
			System.out.println("무언가 5초(오랜시간)가 걸리는 작업을 합니다.");
			Thread.sleep(5000);
			System.out.println("작업 끝");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("actionPerformed method가 return 합니다.");
	}

}
