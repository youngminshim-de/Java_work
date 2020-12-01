package test.frame02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame3 extends JFrame{
	// 필드에 ActionListener
	ActionListener listener= new ActionListener() {
		// 인자로 전달되는 ActionEvent 객체에는 눌러진 버튼의 정보가 들어 있다.
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand())
			{
				case "SEND": JOptionPane.showMessageDialog(MainFrame3.this, "전송합니다.");break;
				case "UPDATE": JOptionPane.showMessageDialog(MainFrame3.this, "수정합니다");break;
				case "DELETE": JOptionPane.showMessageDialog(MainFrame3.this, "삭제합니다");break;
			}
		}
	};
	
	public MainFrame3(String title) {
		super(title);
		setLayout(new FlowLayout());
		
		JButton btn1=new JButton("전송");
		JButton btn2=new JButton("수정");
		JButton btn3=new JButton("삭제");
		add(btn1);
		add(btn2);
		add(btn3);
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		btn3.addActionListener(listener);
		
		btn1.setActionCommand("SEND");
		btn2.setActionCommand("UPDATE");
		btn3.setActionCommand("DELETE");
		

	}
	public static void main(String[] args) {
		MainFrame3 mf2=new MainFrame3("메인프레임");
		mf2.setBounds(100, 100, 500, 300);
		mf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf2.setVisible(true);
	}

}
