package test.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.member.dto.DeptDto;
import test.util.DBConnect;

public class DeptDao {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	DeptDto dto=null;


	public List<DeptDto> selectAll(){
		List<DeptDto> list=new ArrayList<>();
		try {
			conn=new DBConnect().getConn();
			
			String sql="select deptno, dname, loc"
					+ " from dept order by deptno asc";
			pstmt=conn.prepareStatement(sql);
		
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto=new DeptDto();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				
				list.add(dto);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch(Exception e) {}
		}
		return list;
	}
	public DeptDto select(int deptno) {
		try {
			conn=new DBConnect().getConn();
			dto=new DeptDto();
			String sql="select deptno, dname, loc"
					+ " from dept where deptno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch(Exception e) {}
		}
		return dto;
	}
	public boolean delete(int deptno) {
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="delete from dept"
					+ " where deptno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			flag=pstmt.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {}
		}
		return flag>0 ? true:false;
	}
	public boolean update(DeptDto dto) {
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="update dept"
					+ " set dname=?, set loc=?"
					+ " where deptno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getLoc());
			pstmt.setInt(3, dto.getDeptno());
			
			flag=pstmt.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {}
		}
		return flag>0 ? true:false;
			
	}
	public boolean insert(DeptDto dto) {
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="insert into dept"
					+ " values(dept_seq.nextval,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDname());
			pstmt.setString(2, dto.getLoc());
			flag=pstmt.executeUpdate();
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {}
		}
		return flag>0 ? true:false;
	}
	
}
