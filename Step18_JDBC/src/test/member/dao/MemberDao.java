package test.member.dao;
/*
 * 	회원정보(member table)의 내용을
 * 	select
 * 	insert
 * 	update
 * 	delete
 * 	작업을 할 클래스 설계하기
 * 
 * 	- 필요한 객체를 담을 지역변수를 선언하는 위치 선정 중요
 *  - 필요한 객체를 생성하는 위치도 중요하다. 여기서는 Exception 여부에 따라서!
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	// 모든 회원의 정보를 select 하는 메소드
	public List<MemberDto> selectAll(){
		// 굳이 null로 초기화 할 필요x, Exception이 발생하는 것도 아니기 때문
		List<MemberDto> list=new ArrayList<>();
		try {
			conn=new DBConnect().getConn();
			String sql="select num, name, addr"
					+ " from member"
					+ " order by num asc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberDto member=new MemberDto();
				member.setNum(rs.getInt("num"));
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
				list.add(member);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {}
		}
		return list;
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
			String sql="select name, addr"
					+ " from member"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member=new MemberDto();
				member.setNum(num);
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(rs!=null) rs.close();
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
