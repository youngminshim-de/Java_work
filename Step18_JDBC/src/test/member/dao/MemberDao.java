package test.member.dao;
/*
 * 	회원정보(member table)의 내용을
 * 	select
 * 	insert
 * 	update
 * 	delete
 * 	작업을 할 클래스 설계하기
 * 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.member.dto.MemberDto;
import test.util.DBConnect;

public class MemberDao {
	MemberDto member;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public MemberDao() {
		member=null;
		conn=null;
		pstmt=null;
		rs=null;
	}
	// 회원 한명의 정보를 삭제하는 메소드
	public boolean deleteMember(int num) {
		int flag=0;
		
		try {
			conn=new DBConnect().getConn();
			String sql="delete from member where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			flag=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {}
		}
		return flag>0? true:false;
	}
	public boolean insertMember(MemberDto member) {
		int flag=0;
		try{
			conn=new DBConnect().getConn();
			String sql="insert into member"
					+ " values(member_seq.nextval, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getAddr());
			
			flag=pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {}
		}
		return flag>0? true:false;
	}
	public MemberDto selectMember(int num) {
		MemberDto member=null;
		try {
			conn=new DBConnect().getConn();
			String sql="select num, name, addr"
					+ " from member"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member=new MemberDto();
				member.setNum(rs.getInt("num"));
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
				System.out.println("select 성공");
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {}
		}
		return member;
	}
	public boolean updateMember(MemberDto member) {
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="update member"
					+ " set name=?, addr=? "
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getAddr());
			pstmt.setInt(3, member.getNum());
			flag=pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {}
		}
		return flag>0? true:false;
	}
}
