package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 *  Java DataBase Connectivity (JDBC)
 *  
 *  - Oracle에 연결하기 위해서는 드라이버가 들어 있는 ojdbc6.jar 파일이 필요하다.
 *  - 프로젝트 설정에서 ojdbc6.jar 를 사용할 준비를 해야한다.
 */

public class MainClass01 {

	public static void main(String[] args) {
		//DB 연결 객체를 담을 지역변수
		Connection conn=null;
		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 접속할 DB정보
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Table의 내용을 select해서 console에 출력해보기
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select empno, ename, job from emp order by empno asc";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				String job=rs.getString("job");
				System.out.println(empno+"|"+ename+"|"+job);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Main 메소드가 종료 됩니다.");
	}

}
