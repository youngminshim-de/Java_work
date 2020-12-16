package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.member.dao.TodoDao;
import test.member.dto.TodoDto;

public class TodoFrame extends JFrame
					implements ActionListener, PropertyChangeListener{
	JTextField text_content, text_regdate;
	DefaultTableModel model;
	JTable table;
	
	public TodoFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.YELLOW);
		add(topPanel,BorderLayout.NORTH);
		
		text_content=new JTextField(10);
		text_regdate=new JTextField(10);
		JLabel label_content=new JLabel("내용");
		JLabel label_regdate=new JLabel("날짜");
		JButton btn_add=new JButton("추가");
		JButton btn_delete=new JButton("삭제");
		
		topPanel.add(label_content);
		topPanel.add(text_content);
		topPanel.add(label_regdate);
		topPanel.add(text_regdate);
		topPanel.add(btn_add);
		topPanel.add(btn_delete);
		
		btn_add.setActionCommand("add");
		btn_add.addActionListener(this);
		btn_delete.setActionCommand("del");
		btn_delete.addActionListener(this);
		table=new JTable();
		String[] colNames= {"번호", "내용", "날짜"};
		// table의 수정을 하기위한 선언 table 객체는 수정불가
		model=new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==0) {return false;}
				else {return true;}
			}
		};
		table.setModel(model);
		JScrollPane scPane=new JScrollPane(table);
		add(scPane,BorderLayout.CENTER);
		printTodo();
		table.addPropertyChangeListener(this);
		//new UpdateThread().start();
		
	}
	public void printTodo() {
		TodoDao dao=new TodoDao();
		List<TodoDto> list=dao.selectAll();
		model.setRowCount(0);
		for(TodoDto tmp:list) {
			Vector<Object> row=new Vector<>();
			row.add(tmp.getNum());
			row.add(tmp.getContent());
			row.add(tmp.getRegdate());
			
			model.addRow(row);
		}
	}
	public static void main(String[] args) {
		TodoFrame f=new TodoFrame("할일");
		f.setBounds(100, 100, 800, 700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	public void addTodo() {
		TodoDto dto=new TodoDto();
		dto.setContent(text_content.getText());
		dto.setRegdate(text_regdate.getText());
		
		TodoDao dao=new TodoDao();
		boolean isSuccess=dao.insert(dto);
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, "추가 성공!");
			printTodo();
		}else {
			JOptionPane.showMessageDialog(this, "추가 실패!");
		}
	}
	public void deleteTodo() {
		int selectedIndex=table.getSelectedRow();
		if(selectedIndex==-1) {
			JOptionPane.showMessageDialog(this, "삭제할 row를 선택하시오");
			return ;
		}
		int num=(int)table.getValueAt(selectedIndex, 0);
		int result=JOptionPane.showConfirmDialog(this, num+" 번 할일 삭제할거야?");
		if(result==JOptionPane.YES_OPTION) {
			new TodoDao().delete(num);
			printTodo();
		}
	}
	boolean isEditing=false;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {
				int selectedIndex=table.getSelectedRow();
				int num=(int)model.getValueAt(selectedIndex, 0);
				String content=(String)model.getValueAt(selectedIndex, 1);
				String regdate=(String)model.getValueAt(selectedIndex, 2);
				TodoDto dto=new TodoDto(num,content,regdate);
				new TodoDao().update(dto);
				printTodo();
			}
		isEditing=!isEditing;//toggle
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("add")) {
			addTodo();
		}
		else if(command.equals("del")) {
			deleteTodo();
		}
	}
	class UpdateThread extends Thread{
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(5000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				printTodo();
			}
		}
	}

}
