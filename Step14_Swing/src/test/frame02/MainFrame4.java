package test.frame02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame4 extends JFrame implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
			case "SEND": JOptionPane.showMessageDialog(this, "전송합니다.");break;
			case "UPDATE": JOptionPane.showMessageDialog(this, "수정합니다");break;
			case "DELETE": JOptionPane.showMessageDialog(this, "삭제합니다");break;
		}
	}

	public MainFrame4(String title) {
		super(title);
		setLayout(new FlowLayout());
		
		JButton btn1=new JButton("전송");
		JButton btn2=new JButton("수정");
		JButton btn3=new JButton("삭제");
		add(btn1);
		add(btn2);
		add(btn3);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		btn1.setActionCommand("SEND");
		btn2.setActionCommand("UPDATE");
		btn3.setActionCommand("DELETE");
	}
	public static void main(String[] args) {
		MainFrame4 mf2=new MainFrame4("메인프레임");
		mf2.setBounds(100, 100, 500, 300);
		mf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf2.setVisible(true);
	}


}
