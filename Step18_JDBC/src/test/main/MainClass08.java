package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/*
 * 	member 테이블에 있는 회원 목록을
 *  num에 대해서 오름차순 정렬하여
 *  List<MemberDto> 형태로 만들어라.
 */
public class MainClass08 {

	public static void main(String[] args) {
		
		List<MemberDto> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=new DBConnect().getConn();
			String sql="select num,name,addr"
					+ " from member"
					+ " order by num asc";
			String sql2="insert into member values()";
			String sql3="delete member where num=?";
			String sql4="update member set ?=? where ?=?";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				// 첫번째 방법
				// 생성자로 한번에 초기화하지 않는것은 매개변수가 많아졌을 때
				// 생성자가 너무 복잡해보이므로
//				int num=rs.getInt("num");
//				String name=rs.getString("name");
//				String addr=rs.getString("addr");
//				list.add(new MemberDto(num, name, addr));
				// 두번째 방법
				MemberDto member=new MemberDto();
				member.setNum(rs.getInt("num"));
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
				list.add(member);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {}
		}
		// 위의 코드를 수행한 후 list size
		int size=list.size();
		System.out.println(size);
		showInfo(list);
		System.out.println("main 메소드가 종료 됩니다.");
	}
	
	public static void showInfo(List<MemberDto> list) {
		for(MemberDto d:list) {
			System.out.println(d.getNum()+"|"+d.getName()+"|"+d.getAddr());
		}
	}
}
