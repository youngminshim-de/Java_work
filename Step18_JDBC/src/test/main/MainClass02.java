package test.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 *	접속 ip 주소 : 14.63.164.99
 *	아이디 : acorn01
 *	비밀번호 : tiger01
 *
 *	위의 DB에 접속해서 emp 테이블의 내용중에서
 *	사원번호, 사원이름, 부서번호를  콘솔창에 출력해보세요
 *	단, 사원번호에 대해서 오름차순 정렬 (Select 문 연습)
 *	
 */
public class MainClass02 {
	public static void main(String[] args) {
		Connection conn=null;
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@14.63.164.99:1521:xe";
				conn=DriverManager.getConnection(url, "acorn01", "tiger01");
				System.out.println("DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select empno, ename, deptno from emp order by empno asc";
			
			/*
			 너무길면 아래와 같은 형식으로 표현 가능! +이용해서  주의할점은 뒷 문장들은 맨앞을 한칸씩 띄워야한다. 당연히 그러겟지 아니면 문법오류
			String sql="select empno, ename, deptno"
					+ " from emp"
					+ " order by empno asc";
             */
 
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int empno=rs.getInt("empno");
				String ename=rs.getString("ename");
				int deptno=rs.getInt("deptno");
				
				System.out.println(empno+"|"+ename+"|"+deptno);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
