package test.frame01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainClass {

	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setTitle("나의 프레임");
		f.setSize(800, 400);
		f.setLocation(700, 350);
		// 창닫기를 눌러도 프로세스가 자동으로 종료 안됨
		// 이에 아래 setDefaultCloseOperation함수를 이용해서 종료되게함
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//배치매니저를 사용하지 않겟다.(절대좌표, 절대크기로 배치하겠다.)
		f.setLayout(null);
		
		JButton btn=new JButton("click");
		
		// (위치,위치,크기,크기)
		//(x좌표,y좌표,버튼의width,버튼의height)
		btn.setBounds(50,50,100,40);
		
		/*
		ActionListener listener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		*/
		
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("눌러써!?");
				// JOptionPane 클래스의 static Method를 이용해서 알림창 띄우기
				// .showMessageDialog(프레임의 참조값(경고창을 띄울 프레임), 문자열)
				JOptionPane.showMessageDialog(f, "경고!");
				
			}
			
		});
		
		JButton btn2=new JButton("메롱");
		btn2.setBounds(200, 50, 100, 40);
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "약올리지마!");
				
			}
			
		});
		
		//프레임에 버튼추가하기
		f.add(btn);
		f.add(btn2);
		f.setVisible(true);
		
	}

}
