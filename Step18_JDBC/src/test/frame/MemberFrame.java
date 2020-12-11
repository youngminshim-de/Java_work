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

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberFrame extends JFrame 
						implements ActionListener, PropertyChangeListener {
	
	JTextField text_name, text_addr;
	DefaultTableModel model;
	JTable table;
	public MemberFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.YELLOW);
		add(topPanel, BorderLayout.NORTH);
		JLabel label_name=new JLabel("이름");
		JLabel label_addr=new JLabel("주소");
		text_name=new JTextField(10);
		text_addr=new JTextField(10);
		JButton btn_add=new JButton("추가");
		topPanel.add(label_name);
		topPanel.add(text_name);
		topPanel.add(label_addr);
		topPanel.add(text_addr);
		topPanel.add(btn_add);
		
		btn_add.setActionCommand("add");
		btn_add.addActionListener(this);
		
		table=new JTable();
		String[] colNames= {"번호","이름","주소"};
		model=new DefaultTableModel(colNames,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table.setModel(model);
		JScrollPane scPane=new JScrollPane(table);
		add(scPane,BorderLayout.CENTER);
		printMember();
		
		JButton btn_delete=new JButton("삭제");
		topPanel.add(btn_delete);
		btn_delete.setActionCommand("delete");
		btn_delete.addActionListener(this);
		
		table.addPropertyChangeListener(this);
		//new UpdateThread().start();
	}
	public void printMember() {
		MemberDao dao=new MemberDao();
		List<MemberDto> list=dao.selectAll();
		// 기존에 출력된 내용 초기화(0개의 row로)
		model.setRowCount(0);
		for(MemberDto tmp:list) {
		Vector<Object> row=new Vector<>();
		row.add(tmp.getNum());
		row.add(tmp.getName());
		row.add(tmp.getAddr());
		
		model.addRow(row);
		}
		
		
	}

	public static void main(String[] args) {
		MemberFrame f=new MemberFrame("회원정보 관리");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("add")) {
			addMember();
		}else if(command.equals("delete")) {
			int selectedIndex=table.getSelectedRow();
			if(selectedIndex==-1) {
				JOptionPane.showMessageDialog(this, "삭제할 row를 선택해라");
				return;
			}
			int num=(int)table.getValueAt(selectedIndex, 0);
			new MemberDao().deleteMember(num);
			printMember();
		}
		
	}
	// table 칼럼이 수정중인지 여부
	boolean isEditing=false;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("change!");
		System.out.println(evt.getPropertyName());
		// table 칼럼에서 발생한 이벤트가 tableCellEditor와 같을때
		// event는 두번 발생한다. 처음 포커스가 갔을때 포커스가 없어졋을때
		if(evt.getPropertyName().equals("tableCellEditor")) {
			// 즉 수정이 완료됐을때 if문이 실행된다.
			if(isEditing) {
				// 수정중인 테이블 row 값을 읽어와서 DB에 수정 반영하고
				int selectedIndex=table.getSelectedRow();
				int num=(int)model.getValueAt(selectedIndex, 0);
				String name=(String)model.getValueAt(selectedIndex, 1);
				String addr=(String)model.getValueAt(selectedIndex, 2);
				MemberDto dto=new MemberDto(num,name,addr);
				new MemberDao().updateMember(dto);
			}
			// 처음 포커스가 왔을때 isEditing을 true로 바꿔준다.
			isEditing=!isEditing;//(toggle)
		}
		
	}
	public void addMember() {
		String name=text_name.getText();
		String addr=text_addr.getText();
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		MemberDao dao=new MemberDao();
		boolean isSuccess=dao.insertMember(dto);
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, name+" 의 정보 추가성공");
			printMember();
		}
		else {
			JOptionPane.showMessageDialog(this, "추가 실패!");
		}
	}
	//화면을 주기적으로 update 해주는 스레드
	class UpdateThread extends Thread{
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(5000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				printMember();
			}
		}
		
	}

}
