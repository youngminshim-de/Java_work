package test.frame05;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

interface Numbering {
	int ROCK=0; int SISSOR=1; int PAPER=2;
}

public class RockPaperSissors extends JFrame implements ActionListener, Numbering {
	JLabel label1;
	JLabel label2;
	
	public RockPaperSissors(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		JPanel panel=new JPanel();
		JButton btn_sissor=new JButton("가위");
		JButton btn_rock=new JButton("바위");
		JButton btn_paper=new JButton("보");
		label1=new JLabel("낼 패를 고르세요");
		label2=new JLabel("상대방의 패: ");
		panel.add(label1);
		panel.add(btn_sissor);
		panel.add(btn_rock);
		panel.add(btn_paper);
		panel.add(label2);
		
		add(panel,BorderLayout.NORTH);
		
		btn_sissor.addActionListener(this);
		btn_rock.addActionListener(this);
		btn_paper.addActionListener(this);
		
		btn_sissor.setActionCommand("SISSOR");
		btn_rock.setActionCommand("ROCK");
		btn_paper.setActionCommand("PAPER");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Random ran=new Random();
		int user=0;
		int com=ran.nextInt(3);
		String result=null;
		switch(e.getActionCommand()) {
		case "ROCK": user=0;break;
		case "SISSOR": user=1;break;
		case "PAPER": user=2;break;
		}
		
		switch(com) {
			case ROCK: label2.setText("상대방의 패 : "+"바위");break;
			case SISSOR: label2.setText("상대방의 패 : "+"가위");break;
			case PAPER: label2.setText("상대방의 패 : "+"보");break;
		}
		if(user==SISSOR && com==PAPER) {result="You win!";}
		else if(user==ROCK && com==SISSOR) {result="You win!";}
		else if(user==PAPER && com==ROCK) {result="You win!";}
		else if(user==com) {result="Draw";}
		else {result="You Lose T_T";}
		
		JOptionPane.showMessageDialog(this, result);
		
//		switch(e.getActionCommand()) {
//			case "ROCK": 
//				if(com==ROCK) {
//					
//					JOptionPane.showMessageDialog(this, "Draw-");break;
//				}
//				else if(com==SISSOR) {
//					JOptionPane.showMessageDialog(this, "You Win!");break;
//				}
//				else {
//					JOptionPane.showMessageDialog(this, "You Lose!");break;
//				}
//			case "SISSOR":
//				if(com==ROCK) {
//					JOptionPane.showMessageDialog(this, "You Lose!");break;
//				}
//				else if(com==SISSOR) {
//					JOptionPane.showMessageDialog(this, "Draw-");break;
//				}
//				else {
//					JOptionPane.showMessageDialog(this, "You win!");break;
//				}
//			case "PAPER":
//				if(com==ROCK) {
//					JOptionPane.showMessageDialog(this, "You Win!");break;
//				}
//				else if(com==SISSOR) {
//					JOptionPane.showMessageDialog(this, "You Lose!");break;
//				}
//				else {
//					JOptionPane.showMessageDialog(this, "Draw-");break;
//				}
//		}
	}
	public static void main(String[] args) {
		RockPaperSissors game=new RockPaperSissors("가위바위보 게임");
		game.setBounds(100, 100, 500, 500);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
	}

}
