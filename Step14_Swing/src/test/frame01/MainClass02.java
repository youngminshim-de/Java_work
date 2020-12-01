package test.frame01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import test.mypac.MyFrame;

public class MainClass02 {

	public static void main(String[] args) {
		JFrame mf=new MyFrame();
		mf.setTitle("My Frame");
		mf.setSize(500, 300);
		mf.setLocation(100, 100);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
		
	}

}
