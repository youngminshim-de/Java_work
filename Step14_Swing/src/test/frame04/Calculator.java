package test.frame04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame
				implements ActionListener{
	
	JTextField inputText1;
	JTextField inputText2;
	JLabel label1;
	JLabel label2;
	public Calculator(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		JPanel topPanel=new JPanel();
		inputText1=new JTextField(10);
		inputText2=new JTextField(10);
		JButton btn_add=new JButton("+");
		JButton btn_sub=new JButton("-");
		JButton btn_mul=new JButton("*");
		JButton btn_div=new JButton("/");
		label1=new JLabel("=");
		label2=new JLabel();
		
		topPanel.add(inputText1);
		topPanel.add(btn_add);
		topPanel.add(btn_sub);
		topPanel.add(btn_mul);
		topPanel.add(btn_div);
		topPanel.add(inputText2);
		topPanel.add(label1);
		topPanel.add(label2);
		
		add(topPanel, BorderLayout.NORTH);
		
		btn_add.addActionListener(this);
		btn_sub.addActionListener(this);
		btn_mul.addActionListener(this);
		btn_div.addActionListener(this);
		
		btn_add.setActionCommand("+");
		btn_sub.setActionCommand("-");
		btn_mul.setActionCommand("*");
		btn_div.setActionCommand("/");
	}
	public static void main(String[] args) {
		Calculator cal=new Calculator("계산기");
		cal.setBounds(100, 100, 500, 300);
		cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double num1=Double.parseDouble(inputText1.getText());
		double num2=Double.parseDouble(inputText2.getText());
		double result=0;
		
		switch(e.getActionCommand()) {
			case "+" : result=num1+num2;break;
					   
			case "-" : result=num1-num2;break;
					   
			case "*" : result=num1*num2;break;
			   		   
			case "/" : result=num1/num2;break;
		}
		label2.setText(Double.toString(result));
		inputText1.setText("");
		inputText2.setText("");
		
	}

}
