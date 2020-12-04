package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooseFrame extends JFrame implements ActionListener {
	JButton btn_select, btn_select2;
	JTextArea area;

	public FileChooseFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		btn_select=new JButton("파일 선택");
		add(btn_select, BorderLayout.NORTH);
		btn_select.addActionListener(this);
		
		btn_select2=new JButton(".txt 파일 선택하기");
		add(btn_select2, BorderLayout.SOUTH);
		btn_select2.addActionListener(this);
		
		btn_select.setActionCommand("1");
		btn_select.setActionCommand("2");
		
		area=new JTextArea();
		add(area,BorderLayout.CENTER);
		area.setBackground(Color.yellow);

	}
	//일반 파일을 선택하는 메소드
	public void selectGeneral() {
		JFileChooser fc=new JFileChooser("c:/myFolder"); 
		int choose=fc.showOpenDialog(this);
		switch(choose) {
			case JFileChooser.ERROR_OPTION:
				JOptionPane.showMessageDialog(this, "에러발생");break;
				
			case JFileChooser.APPROVE_OPTION:
				File selectedFile=fc.getSelectedFile();
				String fileName=selectedFile.getName();
				JOptionPane.showMessageDialog(this, fileName+" 파일 선택");break;
				
			case JFileChooser.CANCEL_OPTION:
				JOptionPane.showMessageDialog(this, "취소버튼선택");break;
		}
		
	}
	//텍스트 파일을 선택하는 메소드
	public void selectText() {
		JFileChooser fc=new JFileChooser("c:/myFolder");
		
		// 매개변수는 처음 시작위치를 결정, 파일탐색기 열렸을 때 처음뜨는 default 위치
		// 중간에 filter를 만들어 txt파일만 나오게 한다.
		FileNameExtensionFilter filter=
				new FileNameExtensionFilter("텍스트 파일", "txt");
		fc.setFileFilter(filter);
		int choose=fc.showOpenDialog(this);
		if(choose==JFileChooser.APPROVE_OPTION) {
//			char[] cbuf=new char[1024];
//			FileReader freader;
//			try {
//				freader=new FileReader(fc.getSelectedFile());
//				while(true) {
//					int cnt=freader.read(cbuf);
//					if(cnt==-1) {break;}
//					
//				}
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
				FileReader freader;
				BufferedReader breader;
				try {
					freader=new FileReader(fc.getSelectedFile());
					breader=new BufferedReader(freader);
					while(true) {
						String tempStr=breader.readLine();
						if(tempStr==null) {break;}
						area.append(tempStr+"\r\n");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
	public static void main(String[] args) {
		FileChooseFrame f=new FileChooseFrame("파일선택프레임");
		f.setBounds(100, 100, 400, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object temp=e.getSource();
		
		if(temp.equals(btn_select)) {
			selectGeneral();
		}
		else if(temp.equals(btn_select2)) {
			selectText();
		}
		System.out.println("메소드가 종료됩니다.");
	}
}
