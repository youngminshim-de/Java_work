package test.main;

import test.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import test.member.dto.MemberDto;

/*
 * 	Scanner 객체를 이용해서 검색할 회원을 정보를 입력 받고
 * 	입력 받은 숫자를 이용하여 해당 row를 select문을 수행하고,
 * 	결과값을 MemberDto 객체에 저장한다.
 * 
 * 	결과가 없다면 MemberDto 객체 생성하지 말것
 */
public class MainClass07 {

	public static void main(String[] args){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDto member=null;
		Scanner keyboard=new Scanner(System.in);
		
		System.out.println("검색할 회원번호 입력: ");
		int num=keyboard.nextInt();
		
		try {
			conn=new DBConnect().getConn();
			String sql="select name,addr"
					+ " from member"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			boolean isExist=rs.next();
			if(isExist) {
//				String name=rs.getString("name");
//				String addr=rs.getString("addr");
//				member=new MemberDto(num,name,addr);
				member=new MemberDto(
						num, rs.getString("name"), rs.getString("addr")
						);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(member==null) {
			System.out.println(num+ " 번 회원은 존재하지 않습니다.");
		}else {
			System.out.println("번호: "+num+", 이름: "+member.getName()+", 주소: "+member.getAddr());
		}
	}

}
