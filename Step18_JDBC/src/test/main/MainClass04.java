package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * 	executeUpdate 문
 * 
 * 	member 테이블에서
 * 
 *  num 이 ? 인 회원의 addr을 수정해보세요
 *  
 *  수정한 member 테이블에서
 *  
 *  num, name, addr 을 출력해보세요(select)
 *  
 *  단, num에 대해 오름차순으로 정렬해서
 */

public class MainClass04 {

	public static void main(String[] args) {
		Connection conn=null;
		String addr="가리봉동";
		int num=3;
		int flag=0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@LocalHost:1521:xe";
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("DB 접속 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="update member"
					+ " set addr=?"
					+ " where num=?";
			
			pstmt=conn.prepareStatement(sql);
			// ? 에 순서대로 값을 바인딩하기 (바인딩(binding)=> 연결하기, 붙이기)
			pstmt.setString(1, addr);
			pstmt.setInt(2, num);
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 수정 했습니다.");
			
			// Update한 테이블을 Select 하기
			sql="select num,name,addr from member"
				+ " order by num asc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num1=rs.getInt("num");
				String name1=rs.getString("name");
				String addr1=rs.getString("addr");
				System.out.println(num1+"|"+name1+"|"+addr1+"|");
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}

		}
		if(flag>0) {
			System.out.println("작업 성공!");
		}
		else {
			System.out.println("작업 실패!");
		}

	}

}
