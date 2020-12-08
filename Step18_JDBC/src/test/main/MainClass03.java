package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*
 *  executeUpdate (Insert, Update, Delete) 연습
 */

public class MainClass03 {

	public static void main(String[] args) {
		String name="톰캣";
		String addr="건물 옥상";
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@LocalHost:1521:xe";
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("DB 접속 성공");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			// 미완성의 insert문
			String sql="insert into member"
					+ " (num, name, addr)"
					+ " values(member_seq.nextval, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			// 첫번째 물음표의 값을 name로 한다.
			pstmt.setString(1, name);
			// 두번째 물음표의 값을 addr로 한다.
			pstmt.setString(2, addr);
			
			// 실질적으로 DB에 Update한다. (Insert, Delete, Update 등)
			// 완성된 sql 문을 수행하고 변화된 row의 갯수를 리턴한다.
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 저장 했습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(flag>0) {
			System.out.println("작업(INSERT) 성공");
		}
		else {
			System.out.println("작업(INSERT) 실패");
		}
	}

}
