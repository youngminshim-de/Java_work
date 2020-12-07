package test.frame05;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.RandomAccess;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{

	public MainFrame(String title) {
		super(title);
		setLayout(new FlowLayout());
		JButton genBtn=new JButton("로또 번호 뽑기");
		
		add(genBtn);
		
		genBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Random ran=new Random();
		int[] ranNum=new int[6];
		String tempStr="";
		for(int i=0; i<ranNum.length; i++) {
			ranNum[i]=ran.nextInt(45)+1;
			for(int j=i; j>0; j--) {
				if(ranNum[i]==ranNum[j]) {
					ranNum[i]=ran.nextInt(45)+1;
					j=i;
				}
			}
			tempStr+=ranNum[i]+" ";
		}
		JOptionPane.showMessageDialog(this,tempStr);
		
	}
	public static void main(String[] args) {
		MainFrame mf1=new MainFrame("메인 프레임");
		mf1.setBounds(100, 100, 300, 300);
		mf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf1.setVisible(true);
	}

}
