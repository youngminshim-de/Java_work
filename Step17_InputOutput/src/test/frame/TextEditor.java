package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
interface Command{
	int COMMAND_NEW=0; int COMMAND_OPEN=1; int COMMAND_SAVE=2;
}

public class TextEditor extends JFrame implements ActionListener, Command {
	JTextArea ta;
	public TextEditor(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		//메뉴바만들기
		JMenuBar mb=new JMenuBar();
		//메뉴만들기
		JMenu menu1=new JMenu("File");
		JMenu menu2=new JMenu("Help");
		//메뉴아이템 만들기
		JMenuItem item1=new JMenuItem("New");
		JMenuItem item2=new JMenuItem("Open File");
		JMenuItem item3=new JMenuItem("Save");
		
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		//메뉴바에 메뉴항목 add하기
		mb.add(menu1);
		mb.add(menu2);

		//프레임에 메뉴바 등록하기
		setJMenuBar(mb);
		
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		
		item1.setActionCommand("COMMAND_NEW");
		item2.setActionCommand("COMMAND_OPEN");
		item3.setActionCommand("COMMAND_SAVE");
		
		ta=new JTextArea();
		add(ta, BorderLayout.CENTER);
		ta.setBackground(Color.PINK);
		ta.setVisible(false);
	}

	public static void main(String[] args) {
		TextEditor te=new TextEditor("텍스트 편집기");
		te.setBounds(100, 100, 500, 500);
		te.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		te.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String choice=e.getActionCommand();
		switch(choice) {
			case "COMMAND_NEW": textNew();break;
			case "COMMAND_OPEN": textOpen();break;
			case "COMMAND_SAVE": textSave();break;
		}
	}
	public void textNew() {
		ta.setVisible(true);
		ta.grabFocus();
	}
	public void textOpen() {
		JFileChooser fc=new JFileChooser("c:/myFolder");
		FileNameExtensionFilter filter=
				new FileNameExtensionFilter("텍스트", "txt");
		fc.addChoosableFileFilter(filter);
		fc.showOpenDialog(this);
		
		FileReader freader=null;
		BufferedReader breader=null;
		try {
			freader=new FileReader(fc.getSelectedFile());
			breader=new BufferedReader(freader);
			
			while(true) {
				String line=breader.readLine();
				if(line==null) {break;}
				ta.append(line+"\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				ta.setVisible(true);
				breader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void textSave() {
		JFileChooser fc=new JFileChooser("c:/myFolder");
		fc.showSaveDialog(this);
		File file=new File(fc.getSelectedFile().getAbsolutePath());
		BufferedWriter bwr=null;
		try {
			bwr=new BufferedWriter(new FileWriter(file));
				String line=ta.getText();
				bwr.write(line);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bwr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
