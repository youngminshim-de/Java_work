package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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

import test.member.dao.DeptDao;
import test.member.dto.DeptDto;
import test.member.dto.MemberDto;

/*
 *  1. test.dept.dto.DeptDto 클래스를 만드세요
 *  2. test.dept.dao.DeptDao 클래스를 만드세요
 *  3. DeptDto 를 완성해 보세요.
 *  4. DeptDao 를 완성해 보세요.
 *  5. 위에 완성된 DeptDao 를 이용해서 아래 DeptFrame 을 구현해 보세요. 
 */
public class DeptFrame extends JFrame
								implements ActionListener, PropertyChangeListener{
	JTextField text_dname, text_loc;
	DefaultTableModel model;
	JTable table;
	public DeptFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.yellow);
		add(topPanel,BorderLayout.NORTH);
		JLabel label_dname=new JLabel("부서명");
		JLabel label_loc=new JLabel("위치");
		text_dname=new JTextField(10);
		text_loc=new JTextField(10);
		JButton btn_add=new JButton("추가");
		JButton btn_del=new JButton("삭제");
		
		topPanel.add(label_dname);
		topPanel.add(text_dname);
		topPanel.add(label_loc);
		topPanel.add(text_loc);
		topPanel.add(btn_add);
		topPanel.add(btn_del);
		
		btn_add.setActionCommand("add");
		btn_add.addActionListener(this);
		btn_del.setActionCommand("delete");
		btn_del.addActionListener(this);
		
		table=new JTable();
		String[] colNames= {"부서번호", "부서명", "부서위치"};
		model=new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				System.out.println(row+"|"+column);
				if(column==0) {
					return false;
				}else {
					return true;
				}
			}
		};
		table.setModel(model);
		JScrollPane scPane=new JScrollPane(table);
		add(scPane,BorderLayout.CENTER);
		printDept();
		
		new UpdateThread().start();
		
	}
	public void printDept() {
		DeptDao dao=new DeptDao();
		List<DeptDto> list=dao.selectAll();
		
		model.setRowCount(0);
		for(DeptDto tmp:list) {
			Vector<Object> row=new Vector<>();
			row.add(tmp.getDeptno());
			row.add(tmp.getDname());
			row.add(tmp.getLoc());
			model.addRow(row);
		}
	}
	public void addDept() {
		String dname=text_dname.getText();
		String loc=text_loc.getText();
		DeptDto dto=new DeptDto();
		dto.setDname(dname);
		dto.setLoc(loc);
		DeptDao dao=new DeptDao();
		boolean isSuccess=dao.insert(dto);
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, dname+" 의 정보 추가성공");
			printDept();
		} else
		{
			JOptionPane.showMessageDialog(this, "추가 실패!");
		}
		text_dname.setText("");
		text_loc.setText("");
	}
	public void deleteDept() {
		int selectedIndex=table.getSelectedRow();
		if(selectedIndex==-1) {
			JOptionPane.showMessageDialog(this, "삭제할 row를 선택하라");
			return;
		}
		int deptno=(int)table.getValueAt(selectedIndex,0);
		int result=JOptionPane.showConfirmDialog(this, deptno+" 부서를 삭제하겠습니까?");
		if(result==JOptionPane.YES_OPTION) {
			new DeptDao().delete(deptno);
			printDept();
		}
		text_dname.setText("");
		text_loc.setText("");
	}

	public static void main(String[] args) {
		DeptFrame q=new DeptFrame("부서 정보 관리");
		q.setBounds(100, 100, 800, 500);
		q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		q.setVisible(true);

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		boolean isEditing=false;
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {
				int selectedIndex=table.getSelectedRow();
				int deptno=(int)model.getValueAt(selectedIndex, 0);
				String dname=(String)model.getValueAt(selectedIndex,1);
				String loc=(String)model.getValueAt(selectedIndex,2);
				MemberDto dto=new MemberDto(deptno,dname,loc);
			}
		}
		isEditing=!isEditing;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("add")) {
			addDept();
		}else if(command.equals("delete")) {
			deleteDept();
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
				printDept();
			}
		}
		
	}

}
