package test.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import test.member.dto.TodoDto;
import test.util.DBConnect;

public class TodoDao {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	TodoDto dto=null;

	public List<TodoDto> selectAll(){
		List<TodoDto> list=new ArrayList<>();
		try {
			conn=new DBConnect().getConn();
			String sql="select num, content, to_char(regdate,'yyyy-mm-dd') as regdate"
					+ " from todo"
					+ " order by num asc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto=new TodoDto();
				dto.setNum(rs.getInt("num"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			} catch (SQLException e) {}
		}
		return list;
	}
	public TodoDto select(int num) {
		try {
			conn=new DBConnect().getConn();
			dto=new TodoDto();
			String sql="select num, content, to_char(regdate,'yyyy-mm-dd') as regdate"
					+ " from todo"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto.setNum(num);
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			} catch (SQLException e) {}
		}
		return dto;
	}
	public boolean insert(TodoDto dto) {
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="insert into todo"
					+ " values(todo_seq.nextval, ?, to_date(?,'yyyy-mm-dd')";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			pstmt.setString(2, dto.getRegdate());
			flag=pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
				
			}catch(Exception e) {}
		}
		return flag>0? true:false;
	}
	public boolean update(TodoDto dto) {
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="update todo"
					+ " set content=?, regdate=?"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			pstmt.setString(2, dto.getRegdate());
			pstmt.setInt(3, dto.getNum());
			
			flag=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
				
			}catch(Exception e) {}
		}
		return flag>0? true:false;
	}
	public boolean delete(int num) {
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="delete from todo"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			flag=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
				
			}catch(Exception e) {}
		}
		return flag>0? true:false;
	}
}
